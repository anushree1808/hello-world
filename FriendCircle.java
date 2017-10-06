package graphSolutions;
//LeetCode
/*
 * There are N students in a class. Some of them are friends, while some are not. Their friendship 
 * is transitive in nature. For example, if A is a direct friend of B,
 *  and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is 
 *  a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. 
If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. 
And you have to output the total number of friend circles among all the students.

Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.

Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 */

public class FriendCircle 
{
	public int findCircleNum(int[][] M) 
    {
        int n = M.length;
        boolean visited[] = new boolean[n];  
        int num_circles = 0;
        for (int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                num_circles += 1;
                DFS(M,i,visited,n);
            }
        }
        return num_circles;
    }
    
    public void DFS (int M[][],int node,boolean[] visited, int n)
    {
        for(int j=0; j<n; j++)
        {
            if(node!=j && M[node][j]==1)
            {
                if (!visited[j])
                {
                    visited[j] = true;
                    DFS(M,j,visited,n);
                }
            }
        }
    }
}
