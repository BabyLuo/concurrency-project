package ticketingsystem.tools;

public class SectionRange {
    private Section[] sections;

    public SectionRange(int routeNum, int coachNum, int seatNum, int stationNum) {
        sections = new Section[stationNum - 1];
        for (int i = 0; i < sections.length; ++i)
            sections[i] = new Section(routeNum, coachNum, seatNum);
    }

    public void lock(int route, int coach, int seat, int departure, int arrival) {
        int s = departure - 1;
        int e = arrival - 1;
        for (int i = s; i < e; ++i)
            sections[i].lock(route, coach, seat);
    }

    public void unlock(int route, int coach, int seat, int departure, int arrival) {
        int s = departure - 1;
        int e = arrival - 1;
        for (int i = s; i < e; ++i)
            sections[i].unlock(route, coach, seat);
    }

    public boolean isAvailable(int route, int coach, int seat, int departure, int arrival) {
        boolean res = true;
        int s = departure - 1;
        int e = arrival - 1;
        for (int i = s; i < e; ++i)
            res &= sections[i].isAvailable(route, coach, seat);
        return res;
    }

    public void occupy(int route, int coach, int seat, int departure, int arrival) throws IllegalStateException {
        int s = departure - 1;
        int e = arrival - 1;
        for (int i = s; i < e; ++i)
            sections[i].occupy(route, coach, seat);
    }

    public void free(int route, int coach, int seat, int departure, int arrival) throws IllegalStateException {
        int s = departure - 1;
        int e = arrival - 1;
        for (int i = s; i < e; ++i)
            sections[i].free(route, coach, seat);
    }
}