package model.insertNewLocation;

import dataSource.DataSource;
import querySQL.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by davidemagnanimi on 09/09/16 at 12:00.
 */
public class AvailableTime {
    private ArrayList<Date[]> intervals;

    public AvailableTime() {
        this.intervals = new ArrayList<>();
    }

    public AvailableTime(ArrayList<Date[]> intervals) {
        this();
        this.intervals = intervals;
    }

    public AvailableTime(Date from, Date to) {
        this();
        intervals.add(new Date[]{from, to});
    }

    public boolean removeInterval(Location location, Date from, Date to) {
        for (int i = 0; i < intervals.size(); i++) {
            Date intervalFrom = withoutTime(intervals.get(i)[0]),
                    intervalTo = withoutTime(intervals.get(i)[1]);
            from = withoutTime(from);
            to = withoutTime(to);
            if (!intervalFrom.after(from) && !intervalTo.before(to)) {
                Date[] newInterval1 = null, newInterval2 = null;
                if (intervalFrom.compareTo(from) != 0) {
                    newInterval1 = new Date[]{intervalFrom, previousDay(from)};
                    intervals.add(newInterval1);
                }
                if (intervalTo.compareTo(to) != 0) {
                    newInterval2 = new Date[]{nextDay(to), intervalTo};
                    intervals.add(newInterval2);
                }
                Date[] toDeleteInterval = intervals.get(i);
                intervals.remove(toDeleteInterval);
                try {
                    updateDB(location, toDeleteInterval, newInterval1, newInterval2);
                    return true;
                } catch (SQLException e) {
                    return false;
                }
            }

        }
        return false;
    }

    private Date nextDay(Date date) {
        return new Date(date.getTime() + 86400000);
    }

    private Date previousDay(Date date) {
        return new Date(date.getTime() - 86400000);
    }

    public boolean checkAvailability(Date from, Date to) {
        for (Date[] interval : intervals) {
            Date intervalFrom = withoutTime(interval[0]),
                    intervalTo = withoutTime(interval[1]);
            if (!intervalFrom.after(from) && !intervalTo.before(to)) {
                return true;
            }
        }
        return false;
    }

    private void updateDB(Location location, Date[] toDelete, Date[] toAdd1, Date[] toAdd2) throws SQLException {
        PreparedStatement deleteStatement = DataSource.getConnection().prepareStatement(Query.removeAvailability);
        PreparedStatement insertStatement = DataSource.getConnection().prepareStatement(Query.addAvailability);

        deleteStatement.setInt(1, location.getId());
        deleteStatement.setDate(2, new java.sql.Date(toDelete[0].getTime()));
        deleteStatement.setDate(3, new java.sql.Date(toDelete[1].getTime()));
        deleteStatement.execute();

        if (toAdd1 != null) {
            insertStatement.setInt(1, location.getId());
            insertStatement.setDate(2, new java.sql.Date(toAdd1[0].getTime()));
            insertStatement.setDate(3, new java.sql.Date(toAdd1[1].getTime()));
            insertStatement.execute();
        }

        if (toAdd2 != null) {
            insertStatement.setInt(1, location.getId());
            insertStatement.setDate(2, new java.sql.Date(toAdd2[0].getTime()));
            insertStatement.setDate(3, new java.sql.Date(toAdd2[1].getTime()));
            insertStatement.execute();
        }
    }

    private Date withoutTime(Date date) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }
}
