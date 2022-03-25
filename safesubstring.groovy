import com.sap.it.api.mapping.*;

def void safeSubstring(String[] Input, int[] startPosition, int[] length, Output output)
{
    startPosition0 = startPosition[0]
    length0 = length[0]

    for (String entry in Input)
    {
        if (entry.length() < startPosition0)
            output.addValue("")
        else
            if (entry.length() < startPosition0 + length0)
                output.addValue(entry.substring(startPosition0))
            else
                output.addValue(entry.substring(startPosition0, startPosition0 + length0))
    }
}