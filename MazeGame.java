public class MazeGame{

    public Maze CreateMaze(MazeBuilder builder){
        builder.BuildMaze();

        builder.BuildRoom(1);
        builder.BuildRoom(2);
        builder.BuildDoor(1,2);

        return builder.GetMaze();

    }

    public Maze CreateComplexMaze(MazeBuilder builder){
        builder.BuildMaze();

        builder.BuildRoom(1);
        builder.BuildRoom(2);
        builder.BuildDoor(1,2);

        builder.BuildRoom(3);
        builder.BuildRoom(4);
        builder.BuildDoor(3,4);


        return builder.GetMaze();
    }
   

    
}



class Client{
     public static void main(String[] args){
        int rooms, doors;
        Maze maze = new Maze();
        MazeGame game = new MazeGame();
        StandardMazeBuilder builder = new StandardMazeBuilder();
        CountingMazeBuilder builder2 = new CountingMazeBuilder();

        game.CreateMaze(builder);
        game.CreateMaze(builder2);
        maze = builder.GetMaze();

        doors = builder2.GetDoorCounts();
        rooms = builder2.GetRoomCounts();
        System.out.println("There are " + Integer.toString(doors) + " door(s) and " +Integer.toString(rooms)+ " room(s) in the maze");


    }
}