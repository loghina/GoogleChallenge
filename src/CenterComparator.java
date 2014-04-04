import java.util.Comparator;

public class CenterComparator implements Comparator<Center>
{
    @Override
    public int compare(Center x,  Center y)
    {
        // Assume neither string is null. Real code should
        // probably be more robust
        if (x.priority < y.priority)
        {
            return -1;
        }
        if (x.priority > y.priority)
        {
            return 1;
        }
        return 0;
    }
}
