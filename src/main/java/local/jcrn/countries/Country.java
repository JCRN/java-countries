package local.jcrn.countries;

public class Country
{
    private String name;
    private long population;
    private long landMassSize;
    private float medianAge;

    public Country(String name, long population, long landMassSize, float medianAge)
    {
        this.name = name;
        this.population = population;
        this.landMassSize = landMassSize;
        this.medianAge = medianAge;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getPopulation()
    {
        return population;
    }

    public void setPopulation(long population)
    {
        this.population = population;
    }

    public long getLandMassSize()
    {
        return landMassSize;
    }

    public void setLandMassSize(long landMassSize)
    {
        this.landMassSize = landMassSize;
    }

    public float getMedianAge()
    {
        return medianAge;
    }

    public void setMedianAge(float medianAge)
    {
        this.medianAge = medianAge;
    }

    @Override
    public String toString()
    {
        return "Country{" + "name='" + name + '\'' + ", population=" + population + ", landMassSize=" + landMassSize + ", medianAge=" + medianAge + '}';
    }
}


