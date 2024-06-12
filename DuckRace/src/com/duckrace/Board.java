package com.duckrace;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

public class Board implements Serializable {
    private static final String DATA_FILE_PATH = "data/board.dat";
    private static final String STUDENT_ID_FILE_PATH = "conf/student-ids.csv";

    /*
    Read from binary file data/board.dat or create new board (If file not there).
    NOTE: new Board project only created the very first time the app is run.
     */
    public static Board getInstance() {
        Board board = null;

        if (Files.exists(Path.of(DATA_FILE_PATH))) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH))) {
                board = (Board) in.readObject();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            board = new Board();
        }
        return board;
    }
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    // prevent instantiation from outside
    private Board() {
    }

    /*
        Updates the board (racerMap) by making a DuckRacer win.
        This could mean fetching an existing DuckRacer from racerMap
        or creating a new DuckRacer.
     */
    public void update(int id, Reward reward) {
        DuckRacer racer = null;

        if (racerMap.containsKey(id)) {
            racer = racerMap.get(id);
        }
        else {                           // create new DuckRacer
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);    // easy to forget
        }
        racer.win(reward);
        save();
    }

    /*
    Writes "this" Board object to binary file data/board.dat
     */
    private void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE_PATH))) {
            out.writeObject(this);  // write "me" to the file
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This shows data to human user, need to show right side of the map
    public void show() {
        if (racerMap.isEmpty()) {
            System.out.println("There are currently no results to show");
            System.out.println();
        } else {
            Collection<DuckRacer> racers = racerMap.values();

            System.out.println("id    name    wins     rewards");
            System.out.println("--    ----    ----     -------");

            for(DuckRacer racer : racers) {
                System.out.printf("%s %s %s %s\n",
                        racer.getId(), racer.getName(), racer.getWins(), racer.getRewards());
            }
        }
    }

    // TESTING PURPOSES
    void dumpStudentIdMap() {
        System.out.println(studentIdMap);
    }

    /*
        Populates student IdMap from file conf/student-ids.csv
     */
    private Map<Integer, String> loadStudentIdMap() {
        Map<Integer,String> map = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(STUDENT_ID_FILE_PATH));
            // for each line (String), we need to split it into tokens based on commas
            for(String line : lines) {
                String[] tokens = line.split(",");  // returns ["1", "Amir"]
                Integer id = Integer.valueOf(tokens[0]);
                String name = tokens[1];
                map.put(id, name);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}