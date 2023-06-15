import java.util.Random;
import java.util.ArrayList;
import java.util.List;

abstract class MazeBuilder{
    public abstract void BuildMaze();

    public abstract void BuildRoom(int room);

    public abstract void BuildDoor(int roomFrom, int roomTo);

    public abstract Maze GetMaze();
}
//------------------------------------------
class StandardMazeBuilder extends MazeBuilder{
    Maze currentMaze;
    List<String> directions = new ArrayList<>();
    

    
    StandardMazeBuilder(){
        this.directions.add("North");
        this.directions.add("South");
        this.directions.add("East");
        this.directions.add("West");
    }

    public void BuildMaze(){
        currentMaze = new Maze();
    }

    public void BuildRoom(int n){
        
        if(!(currentMaze.RoomNo(n) instanceof Room)){
            Room room = new Room(n);
            currentMaze.AddRoom(room);

            room.setSide("North", new Wall());
            room.setSide("South", new Wall());
            room.setSide("East", new Wall());
            room.setSide("West", new Wall());
        }

    }

    public void BuildDoor(int roomFrom, int roomTo){
        Room r1 = currentMaze.RoomNo(roomFrom);
        Room r2 = currentMaze.RoomNo(roomTo);
        Door d = new Door(r1, r2);

        r1.setSide("North", d);
        r2.setSide("South", d);
    }

    public Maze GetMaze(){
        return currentMaze;
    }

    public String CommonWall(Room r1, Room r2){
        //arbitrarily determine the direction betwen two walls
        Random random = new Random();
        int randomIndex = random.nextInt(directions.size());
        return this.directions.get(randomIndex);
    }

}
//------------------------------------------
class CountingMazeBuilder extends MazeBuilder{
    Maze currentMaze;
    int rooms, doors;
    CountingMazeBuilder(){
        this.rooms = 0;
        this.doors = 0;
    }
    public void BuildMaze(){
        currentMaze = new Maze();
    }

    public void BuildRoom(int n){
        rooms++;
    }

    public void BuildDoor(int roomFrom, int roomTo){
        doors++;
    }

    public Maze GetMaze(){
        return currentMaze;
    }
    public int GetDoorCounts(){
        return this.doors;
    }
    public int GetRoomCounts(){
        return this.rooms;
    }
}

//------------------------------------------


class Maze{
    ArrayList<Room> rooms;
    Maze(){
        rooms = new ArrayList<Room>();
    }

    public void AddRoom(Room room){
        System.out.println("Room "+ Integer.toString(room.roomNo) + " constructing");
        rooms.add(room);
    }

    public Room RoomNo(int r){
        for(Room currentRoom : rooms){
            if (currentRoom.roomNo == r){
                return currentRoom;
            }
        }
        return null;

    }
}


