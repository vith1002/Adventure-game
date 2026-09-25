package Adventure;

public class Player {

    private Room currentRoom;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean move(String direction) {

        Room nextRoom = null;

        switch (direction.toLowerCase()) {

            case "north":
                nextRoom = currentRoom.getNorth();
                break;

            case "south":
                nextRoom = currentRoom.getSouth();
                break;

            case "east":
                nextRoom = currentRoom.getEast();
                break;

            case "west":
                nextRoom = currentRoom.getWest();
                break;
        }

        if (nextRoom != null) {
            currentRoom = nextRoom;
            return true;
        }

        return false;
    }
}