public class Staff {

    StaffMember[] staffList;

    //Set list staff
    public Staff ()
    {
        staffList = new StaffMember[8];
        staffList[0] = new Executive ("Sam", "123 Main Line",
        "555-0469", "123-45-6789", 2423.07);
        staffList[1] = new Employee ("Carla", "456 Off Line",
        "555-0101", "987-65-4321", 1246.15);
        staffList[2] = new Employee ("Woody", "789 Off Rocker",
        "555-0000", "010-20-3040", 1169.23);
        staffList[3] = new Hourly ("Diane", "678 Fifth Ave.",
        "555-0690", "958-47-3625", 10.55);
        staffList[4] = new Volunteer ("Norm", "987 Suds Blvd.",
        "555-8374");
        staffList[5] = new Volunteer ("Cliff", "321 Duds Lane",
        "555-7282");
        staffList[6] = new Commission("Vespa","District K","555-9087", "953-123-9237",6.25,20.0);
        staffList[7] = new Commission("Crabro","District J","555-9783", "953-123-3461",9.75,15.0);
        ((Executive)staffList[0]).awardBonus (500.00);
        ((Hourly)staffList[3]).addHours (40);
        ((Commission)staffList[6]).addHours(35);
        ((Commission)staffList[7]).addHours(40);
        ((Commission)staffList[6]).TotalSales(400);
        ((Commission)staffList[7]).TotalSales(950);
    }

    //Bayar semua staff
    public void payday ()
    {
        double amount;
        for (int count=0; count < staffList.length; count++)
        {
            System.out.println (staffList[count]);
            amount = staffList[count].pay(); // polymorphic
            if (amount == 0.0)
            System.out.println ("Thanks!");
            else
            System.out.println ("Paid: " + amount);
            System.out.println ("-----------------------------------");
        }
    }

}