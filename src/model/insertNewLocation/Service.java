package model.insertNewLocation;

/**
 * Created by tizianoditoma on 06/09/16.
 */
public class Service {

    private boolean wifi;
    private boolean smokingRoom;
    private boolean petsAllowed;
    private boolean parking;
    private boolean roomService;
    private boolean conditionedAir;
    private boolean views;
    private boolean plasmaTv;

    public Service(boolean wifi, boolean smokingRoom, boolean petsAllowed, boolean parking, boolean roomService,
                   boolean conditionedAir, boolean views, boolean plasmaTv) {

        this.wifi = wifi;
        this.smokingRoom = smokingRoom;
        this.petsAllowed = petsAllowed;
        this.parking = parking;
        this.roomService = roomService;
        this.conditionedAir = conditionedAir;
        this.views = views;
        this.plasmaTv = plasmaTv;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isSmokingRoom() {
        return smokingRoom;
    }

    public void setSmokingRoom(boolean smokingRoom) {
        this.smokingRoom = smokingRoom;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public boolean isRoomService() {
        return roomService;
    }

    public void setRoomService(boolean roomService) {
        this.roomService = roomService;
    }

    public boolean isConditionedAir() {
        return conditionedAir;
    }

    public void setConditionedAir(boolean conditionedAir) {
        this.conditionedAir = conditionedAir;
    }

    public boolean isViews() {
        return views;
    }

    public void setViews(boolean views) {
        this.views = views;
    }

    public boolean isPlasmaTv() {
        return plasmaTv;
    }

    public void setPlasmaTv(boolean plasmaTv) {
        this.plasmaTv = plasmaTv;
    }
}
