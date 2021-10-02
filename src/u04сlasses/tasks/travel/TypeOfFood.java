package u04сlasses.tasks.travel;

public enum TypeOfFood {
    NOT_INCLUDED,
    BREAKFAST,
    ALL_INCLUSIVE;

    @Override
    public String toString() {
        return super.toString().replace('_', ' ').toLowerCase();
    }
}
