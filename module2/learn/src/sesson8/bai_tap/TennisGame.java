package sesson8.bai_tap;

import java.util.Scanner;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        if (m_score1 == m_score2) {
            return tieTheScore(m_score1);
        } else if (m_score1>=4 || m_score2>=4) {
            return advantagePlayer(player1Name,player2Name,m_score1, m_score2);
        } else {
            return otherResults(m_score1, m_score2);
        }
    }
    public static String tieTheScore(int score){
        String[] scoreName = {"Love-All", "Fifteen-All", "Thirty-All", "Forty-All", "Deuce"};
        return scoreName[score];
    }
    public static String advantagePlayer(String player1Name, String player2name,int player1Score, int player2Score){
        String result = "";
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) {
            result = "Advantage " + player1Name;
        } else if (minusResult ==-1) {
            result = "Advantage " + player2name;
        } else if (minusResult>=2){
            result = "Win for " + player1Name;
        } else{
            result = "Win for " + player2name;
        }
        return result;
    }
    public static String otherResults(int player1Score, int player2Score){
        String[] str = {"Love", "Fifteen", "Thirty", "Forty"};
        return str[player1Score] + "-" + str[player2Score];
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter player1's name: ");
        String player1Name = sn.nextLine();
        System.out.println("Enter player2's name: ");
        String player2Name = sn.nextLine();
        System.out.println("Enter player1's score: ");
        int player1Score = sn.nextInt();
        System.out.println("Enter player2's score: ");
        int player2Score = sn.nextInt();
        String score = getScore(player1Name, player2Name, player1Score, player2Score);
        System.out.println(score);
    }
}
