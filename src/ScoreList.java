import java.io.*;

public class ScoreList {
    int[] scores;
    String[] players;

    ScoreList(String fileName) {

        File file = new File(fileName);
        scores = new int[5];
        players = new String[5];
        try {

            if(!file.exists()){
                file.createNewFile();
            }

            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                String s;
                int i = 0;
                while ((s = in.readLine()) != null) {
                    String[] result = s.split(" ");
                    players[i] = result[0];
                    scores[i++] = Integer.parseInt(result[1], 10);

                }
            } finally {

                in.close();
            }

        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeNewList() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("ScoreList.txt", "UTF-8");
            int i = 0;
            for (String user : players) {
                if (user == null) {
                    break;
                }
                writer.println(user + " " + scores[i++]);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
