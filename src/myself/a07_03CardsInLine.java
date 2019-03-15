package myself;

public class a07_03CardsInLine {

    public static int cardsWin(int[] cards) {
        int[][] f = new int[cards.length][cards.length];
        int[][] s = new int[cards.length][cards.length];

        for (int j = 0; j < f.length; j++) {
            f[j][j] = cards[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(cards[i] + s[i + 1][j], cards[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][f.length - 1], s[0][f.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 1};
        System.out.println(cardsWin(arr));
    }


}
