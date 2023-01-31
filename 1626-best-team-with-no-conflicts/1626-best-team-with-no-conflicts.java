class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        
        int n = ages.length;
        Player[] players = new Player[n];
        
        for(int i = 0 ; i < n ; i++) {
            
            players[i] = new Player(scores[i], ages[i]);
        }
        
        Arrays.sort(players, (player1, player2) -> {
            
            if(player1.age == player2.age) {
                
                return Integer.compare(player1.score, player2.score);
            }
            return Integer.compare(player1.age, player2.age);
        });
        
        int[][] dp = new int[n][n + 1];
        
        for(int[] row : dp) {
            
            Arrays.fill(row, -1);
        }
        
        return findHighestScore(0, players.length, players, dp);
    }
    
    private int findHighestScore(int idx, int prev, Player[] players, int[][] dp) {
        
        if(idx == players.length) {
            
            return 0;
        }
        
        if(dp[idx][prev] != -1) {
            
            return dp[idx][prev];
        }
        
        int option1 = findHighestScore(idx + 1, prev, players, dp);
        int option2 = 0;
        
        if(prev == players.length || players[idx].score >= players[prev].score) {
            
            option2 = players[idx].score + findHighestScore(idx + 1, idx, players, dp);
        }
        
        int maxScore = Math.max(option1, option2);
        
        return dp[idx][prev] = maxScore;
    }
}

class Player {
    
    int score;
    int age;
    
    Player(int score, int age) {
        
        this.score = score;
        this.age = age;
    }
}