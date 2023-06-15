abstract class MapSite {
    public abstract void Enter();
}
class Room extends MapSite{
    int roomNo;
    Room(int roomNo){
        this.roomNo = roomNo;
    }    
    
    public void Enter(){
        System.out.println("Entering room "+ Integer.toString(roomNo));
    }

    public void getSide(String direction){
        direction = direction.toLowerCase();
        System.out.println(direction + " direction");
    }

    public void setSide(String direction, MapSite mapsite){
        direction = direction.toLowerCase();
        if(mapsite instanceof Door){
            System.out.print("Door ");
        }else if (mapsite instanceof Wall){
            System.out.print("Wall ");
        }
        System.out.println("is being built on the " + direction + " side");
    }

}

class Wall extends MapSite{
    public void Enter(){
        System.out.println("Walked into a wall and hurt your nose");
    }
}

class Door extends MapSite {
    Room room1;
    Room room2;
    boolean isOpen;
    Door(Room r1, Room r2){
        this.room1 = r1;
        this.room2 = r2;
        this.isOpen = false;
    }
    public void Enter(){
        if (isOpen){
            System.out.println("Opened the door");
        }else{
            System.out.println("Door is locked");
        }
    }
}