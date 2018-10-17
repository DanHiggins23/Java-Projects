public class BlackjackExample {
    public static void main(String[] args) {
    }

    public int play(int player, int dealer) {
        int winner = 0;

        if (player > 32 || player <= 0 || dealer > 32 || dealer <= 0) {
            winner = 0;
        } else {
            if (player > 21 && dealer < 21) {
                winner = dealer;
            } else if (dealer > 21 && player < 21) {
                winner = player;
            } else {
                if (player > dealer) {
                    winner = player;
                } else if (dealer > player) {
                    winner = dealer;
                }
            }
        }

        return winner;
    }
}
