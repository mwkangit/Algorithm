#include <string>
#include <vector>

using namespace std;


int circle(vector<vector<int>>&graph, int x1, int y1, int x2, int y2){
    int mini = 10001;
    int sub, sub2;
    
    int start = graph[x1][y1];
    
    for(int i = x1 ; i < x2 ; i++){
        graph[i][y1] = graph[i+1][y1];
        mini = min(mini, graph[i][y1]);
    }
    for(int i = y1 ; i < y2 ; i++){
        graph[x2][i] = graph[x2][i+1];
        mini = min(mini, graph[x2][i]);
    }
    for(int i = x2 ; i > x1 ; i--){
        graph[i][y2] = graph[i-1][y2];
        mini = min(mini, graph[i][y2]);
    }
    for(int i = y2 ; i > y1 ; i--){
        graph[x1][i] = graph[x1][i-1];
        mini = min(mini, graph[x1][i]);
    }
    
    graph[x1][y1+1] = start;
    mini = min(mini, start);
    
    return mini;
    
}

vector<int> solution(int rows, int columns, vector<vector<int>> queries) {

    vector<int> answer;
    
    vector<vector<int>>graph(rows, vector<int>(columns));
    int count = 1;
    for(int i = 0 ; i < rows ; i++){
        for(int j = 0 ; j < columns ; j++){
            graph[i][j] = count;
            count++;
        }
    }
    for(int i = 0 ; i < queries.size() ; i++){
        answer.push_back(circle(graph, queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1));
        
    }
    
    
    return answer;
}
