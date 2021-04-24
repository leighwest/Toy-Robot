import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(args.length < 1) {
            System.err.println("Usage: gradle run --args='[name of instructions file]'");
            System.exit(1);
        }
        String filename = args[0];
        File file = new File(filename);

        try {
            ArrayList<ICommand> commands = readCommands(file);
            Robot robot = new Robot();
            for (ICommand command: commands) {
                command.execute(robot);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + file);
        }
    }

    public static ArrayList<ICommand> readCommands(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("[, \r\n]");

        ArrayList<ICommand> commands = new ArrayList<>();

        while (scanner.hasNext()) {
            String commandName = scanner.next();
            switch (commandName) {
                case "PLACE":
                    int posX = scanner.nextInt();
                    int posY = scanner.nextInt();
                    String orientation = scanner.next();
                    PlaceCommand placeCommand = new PlaceCommand(posX, posY, orientation);
                    commands.add(placeCommand);
                    break;
                case "LEFT":
                    LeftCommand leftCommand = new LeftCommand();
                    commands.add(leftCommand);
                    break;
                case "RIGHT":
                    RightCommand rightCommand = new RightCommand();
                    commands.add(rightCommand);
                    break;
                case "MOVE":
                    MoveCommand moveCommand = new MoveCommand();
                    commands.add(moveCommand);
                    break;
                case "REPORT":
                    ReportCommand reportCommand = new ReportCommand();
                    commands.add(reportCommand);
                    break;
                case "":
                    break;
                default:
                    System.err.println("Illegal command: " + commandName);
            }
        }
        return commands;
    }
}

