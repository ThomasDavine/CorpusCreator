import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Urls
{
  HashMap<String, String> u = new HashMap<String, String>();
  private ArrayList<String> companyUrl = new ArrayList<String>();

  private String[] company = new String[0];

  public Urls()
  {
    this.u.put("Alcoa", new String("alcoa_inc"));
    this.u.put("Apple Inc.", new String("apple_computer_inc"));
    this.u.put("Abbott Laboratories", new String("abbott_laboratories"));
    this.u.put("American Electric Power Co.", new String("american_electric_power_company"));
    this.u.put("Allstate Corp", new String("allstate_corporation"));
    this.u.put("Amgen Inc.", new String("amgen_inc"));
    this.u.put("Amazon.com", new String("amazon_inc"));
    this.u.put("Avon Products Inc", new String("avon_products_inc"));
    this.u.put("American Express Inc", new String("american_express_company"));
    this.u.put("Boeing Co", new String("boeing_company"));
    this.u.put("Bank of America Corp", new String("bank_of_america_corporation"));
    this.u.put("Baxter International Inc", new String("baxter_international_inc"));
    this.u.put("Baker Hughes", new String("baker_hughes_inc"));
    this.u.put("Bank of New York", new String("bank_of_new_york_company"));
    this.u.put("Bristol-Myers Squibb", new String("bristol_myers_squibb_company"));
    this.u.put("Berkshire Hathaway", new String("berkshire_hathaway_inc"));
    this.u.put("Caterpillar Inc", new String("caterpillar_inc"));
    this.u.put("Citigroup Inc", new String("citigroup_inc"));
    this.u.put("Colgate-Palmolive Co", new String("colgate_palmolive_company"));
    this.u.put("Comcast Corporation", new String("comcast_corporation"));
    this.u.put("Capital One Financial Corp", new String("capital_one_financial_corporation"));
    this.u.put("ConocoPhillips", new String("conocophillips_inc"));
    this.u.put("Costco", new String("costco_wholesale_corporation"));
    this.u.put("Campbell Soup Company", new String("campbell_soup_company"));
    this.u.put("Cisco Systems", new String("cisco_systems_inc"));
    this.u.put("CVS Caremark", new String("cvscaremark_corporation"));
    this.u.put("Chevron", new String("chevron_corporation"));
    this.u.put("DuPont", new String("du_pont_de_nemours_and_company_e_i"));
    this.u.put("Dell", new String("dell_inc"));
    this.u.put("The Walt Disney Company", new String("disney_walt_company"));
    this.u.put("Dow Chemical", new String("dow_chemical_company"));
    this.u.put("Devon Energy", new String("devon_energy_corporation"));
    this.u.put("EMC Corporation", new String("emc_corporation"));
    this.u.put("Entergy", new String("entergy_corporation"));
    this.u.put("Exelon", new String("exelon_corporation"));
    this.u.put("Ford Motor", new String("ford_motor_company"));
    this.u.put("Freeport-McMoran", new String("freeportmcmoran_copper_and_gold_inc"));
    this.u.put("FedEx", new String("fedex_corporation"));
    this.u.put("General Dynamics", new String("general_dynamics_corporation"));
    this.u.put("General Electric Co.", new String("general_electric_company"));
    this.u.put("Gilead Sciences", new String("gilead_sciences_inc"));
    this.u.put("Google Inc.", new String("google_inc"));
    this.u.put("Goldman Sachs", new String("goldman_sachs_group_inc"));
    this.u.put("Halliburton", new String("halliburton_company"));
    this.u.put("Home Depot", new String("home_depot_inc"));
    this.u.put("H. J. Heinz Company", new String("h_j_heinz_company"));
    this.u.put("Honeywell", new String("honeywell_international_inc"));
    this.u.put("Hewlett Packard Co", new String("hewlett_packard_corporation"));
    this.u.put("International Business Machines", new String("international_business_machines"));
    this.u.put("Intel Corporation", new String("intel_corporation"));
    this.u.put("Johnson & Johnson Inc", new String("johnson_and_johnson"));
    this.u.put("JP Morgan Chase & Co", new String("morgan_j_p_chase_and_company"));
    this.u.put("Kraft Foods Inc", new String("kraft-foods-inc"));
    this.u.put("The Coca-Cola Company", new String("coca_cola_company"));
    this.u.put("Lockheed-Martin", new String("lockheed_martin_corporation"));
    this.u.put("Lowe's", new String("lowes_companies"));
    this.u.put("Mastercard Inc", new String("mastercard-inc"));
    this.u.put("McDonald's Corp", new String("mcdonalds_corporation"));
    this.u.put("Medtronic Inc.", new String("medtronic_inc"));
    this.u.put("Metlife Inc.", new String("metlife_inc"));
    this.u.put("3M Company", new String("3m_company"));
    this.u.put("Altria Group", new String("altria_group_inc"));
    this.u.put("Monsanto", new String("monsanto_company"));
    this.u.put("Merck & Co.", new String("merck_and_company"));
    this.u.put("Morgan Stanley", new String("morgan_stanley"));
    this.u.put("Microsoft", new String("microsoft_corporation"));
    this.u.put("Nike", new String("nike_inc"));
    this.u.put("National Oilwell Varco Inc", new String("national_oilwell_varco_inc"));
    this.u.put("Norfolk Southern Corp", new String("norfolk_southern_corporation"));
    this.u.put("News Corp.", new String("news_corporation"));
    this.u.put("NYSE Euronext", new String("nyse-euronext"));
    this.u.put("Oracle Corporation", new String("oracle_corporation"));
    this.u.put("Occidental Petroleum Corp", new String("occidental_petroleum_corporation"));
    this.u.put("Pepsico Inc", new String("pepsico_inc"));
    this.u.put("Pfizer Inc", new String("pfizer_inc"));
    this.u.put("Procter & Gamble Co", new String("procter_and_gamble"));
    this.u.put("Phillip Morris International", new String("philip-morris-international-inc"));
    this.u.put("Qualcomm Inc", new String("qualcomm_inc"));
    this.u.put("Regions Financial", new String("regions_financial_corporation"));
    this.u.put("Raytheon Co", new String("raytheon_company"));
    this.u.put("Sprint Nextel Corp", new String("sprint_nextel_corporation"));
    this.u.put("Schlumberger", new String("schlumberger_ltd"));
    this.u.put("Sara Lee Corporation", new String("sara_lee_corporation"));
    this.u.put("Southern Company", new String("southern_company"));
    this.u.put("AT&T Inc", new String("at_and_t"));
    this.u.put("Target Corp", new String("target_corporation"));
    this.u.put("Time Warner Inc", new String("time_warner_inc"));
    this.u.put("Texas Instruments", new String("texas_instruments_inc"));
    this.u.put("UnitedHealth Group Inc", new String("united_health_group_inc"));
    this.u.put("United Parcel Service Inc", new String("united_parcel_service_inc"));
    this.u.put("US Bancorp", new String("us_bancorp"));
    this.u.put("United Technologies Corp", new String("united_technologies_corporation"));
    this.u.put("Verizon Communications Inc", new String("verizon_communications_inc"));
    this.u.put("Walgreens", new String("walgreen_company"));
    this.u.put("Wells Fargo", new String("wells_fargo_and_company"));
    this.u.put("Williams Companies", new String("williams_companies"));
    this.u.put("Wal-Mart", new String("wal_mart_stores_inc"));
    this.u.put("Weyerhauser Co", new String("weyerhaeuser_company"));
    this.u.put("Exxon Mobil Corp", new String("exxon_mobil_corporation"));
    this.u.put("Xerox Corp", new String("xerox_corporation"));

    Iterator<String> it = this.u.keySet().iterator();

    while (it.hasNext()) {
      String current = (String)it.next();
      this.companyUrl.add(String.format("http://topics.nytimes.com/topics/news/business/companies/%s/index.html", new Object[] { this.u.get(current) }));
    }
  }

  public Urls(String[] company)
  {
    this.u.put("Alcoa", new String("alcoa_inc"));
    this.u.put("Apple Inc.", new String("apple_computer_inc"));
    this.u.put("Abbott Laboratories", new String("abbott_laboratories"));
    this.u.put("American Electric Power Co.", new String("american_electric_power_company"));
    this.u.put("Allstate Corp", new String("allstate_corporation"));
    this.u.put("Amgen Inc.", new String("amgen_inc"));
    this.u.put("Amazon.com", new String("amazon_inc"));
    this.u.put("Avon Products Inc", new String("avon_products_inc"));
    this.u.put("American Express Inc", new String("american_express_company"));
    this.u.put("Boeing Co", new String("boeing_company"));
    this.u.put("Bank of America Corp", new String("bank_of_america_corporation"));
    this.u.put("Baxter International Inc", new String("baxter_international_inc"));
    this.u.put("Baker Hughes", new String("baker_hughes_inc"));
    this.u.put("Bank of New York", new String("bank_of_new_york_company"));
    this.u.put("Bristol-Myers Squibb", new String("bristol_myers_squibb_company"));
    this.u.put("Berkshire Hathaway", new String("berkshire_hathaway_inc"));
    this.u.put("Caterpillar Inc", new String("caterpillar_inc"));
    this.u.put("Citigroup Inc", new String("citigroup_inc"));
    this.u.put("Colgate-Palmolive Co", new String("colgate_palmolive_company"));
    this.u.put("Comcast Corporation", new String("comcast_corporation"));
    this.u.put("Capital One Financial Corp", new String("capital_one_financial_corporation"));
    this.u.put("ConocoPhillips", new String("conocophillips_inc"));
    this.u.put("Costco", new String("costco_wholesale_corporation"));
    this.u.put("Campbell Soup Company", new String("campbell_soup_company"));
    this.u.put("Cisco Systems", new String("cisco_systems_inc"));
    this.u.put("CVS Caremark", new String("cvscaremark_corporation"));
    this.u.put("Chevron", new String("chevron_corporation"));
    this.u.put("DuPont", new String("du_pont_de_nemours_and_company_e_i"));
    this.u.put("Dell", new String("dell_inc"));
    this.u.put("The Walt Disney Company", new String("disney_walt_company"));
    this.u.put("Dow Chemical", new String("dow_chemical_company"));
    this.u.put("Devon Energy", new String("devon_energy_corporation"));
    this.u.put("EMC Corporation", new String("emc_corporation"));
    this.u.put("Entergy", new String("entergy_corporation"));
    this.u.put("Exelon", new String("exelon_corporation"));
    this.u.put("Ford Motor", new String("ford_motor_company"));
    this.u.put("Freeport-McMoran", new String("freeportmcmoran_copper_and_gold_inc"));
    this.u.put("FedEx", new String("fedex_corporation"));
    this.u.put("General Dynamics", new String("general_dynamics_corporation"));
    this.u.put("General Electric Co.", new String("general_electric_company"));
    this.u.put("Gilead Sciences", new String("gilead_sciences_inc"));
    this.u.put("Google Inc.", new String("google_inc"));
    this.u.put("Goldman Sachs", new String("goldman_sachs_group_inc"));
    this.u.put("Halliburton", new String("halliburton_company"));
    this.u.put("Home Depot", new String("home_depot_inc"));
    this.u.put("H. J. Heinz Company", new String("h_j_heinz_company"));
    this.u.put("Honeywell", new String("honeywell_international_inc"));
    this.u.put("Hewlett Packard Co", new String("hewlett_packard_corporation"));
    this.u.put("International Business Machines", new String("international_business_machines"));
    this.u.put("Intel Corporation", new String("intel_corporation"));
    this.u.put("Johnson & Johnson Inc", new String("johnson_and_johnson"));
    this.u.put("JP Morgan Chase & Co", new String("morgan_j_p_chase_and_company"));
    this.u.put("Kraft Foods Inc", new String("kraft-foods-inc"));
    this.u.put("The Coca-Cola Company", new String("coca_cola_company"));
    this.u.put("Lockheed-Martin", new String("lockheed_martin_corporation"));
    this.u.put("Lowe's", new String("lowes_companies"));
    this.u.put("Mastercard Inc", new String("mastercard-inc"));
    this.u.put("McDonald's Corp", new String("mcdonalds_corporation"));
    this.u.put("Medtronic Inc.", new String("medtronic_inc"));
    this.u.put("Metlife Inc.", new String("metlife_inc"));
    this.u.put("3M Company", new String("3m_company"));
    this.u.put("Altria Group", new String("altria_group_inc"));
    this.u.put("Monsanto", new String("monsanto_company"));
    this.u.put("Merck & Co.", new String("merck_and_company"));
    this.u.put("Morgan Stanley", new String("morgan_stanley"));
    this.u.put("Microsoft", new String("microsoft_corporation"));
    this.u.put("Nike", new String("nike_inc"));
    this.u.put("National Oilwell Varco Inc", new String("national_oilwell_varco_inc"));
    this.u.put("Norfolk Southern Corp", new String("norfolk_southern_corporation"));
    this.u.put("News Corp.", new String("news_corporation"));
    this.u.put("NYSE Euronext", new String("nyse-euronext"));
    this.u.put("Oracle Corporation", new String("oracle_corporation"));
    this.u.put("Occidental Petroleum Corp", new String("occidental_petroleum_corporation"));
    this.u.put("Pepsico Inc", new String("pepsico_inc"));
    this.u.put("Pfizer Inc", new String("pfizer_inc"));
    this.u.put("Procter & Gamble Co", new String("procter_and_gamble"));
    this.u.put("Phillip Morris International", new String("philip-morris-international-inc"));
    this.u.put("Qualcomm Inc", new String("qualcomm_inc"));
    this.u.put("Regions Financial", new String("regions_financial_corporation"));
    this.u.put("Raytheon Co", new String("raytheon_company"));
    this.u.put("Sprint Nextel Corp", new String("sprint_nextel_corporation"));
    this.u.put("Schlumberger", new String("schlumberger_ltd"));
    this.u.put("Sara Lee Corporation", new String("sara_lee_corporation"));
    this.u.put("Southern Company", new String("southern_company"));
    this.u.put("AT&T Inc", new String("at_and_t"));
    this.u.put("Target Corp", new String("target_corporation"));
    this.u.put("Time Warner Inc", new String("time_warner_inc"));
    this.u.put("Texas Instruments", new String("texas_instruments_inc"));
    this.u.put("UnitedHealth Group Inc", new String("united_health_group_inc"));
    this.u.put("United Parcel Service Inc", new String("united_parcel_service_inc"));
    this.u.put("US Bancorp", new String("us_bancorp"));
    this.u.put("United Technologies Corp", new String("united_technologies_corporation"));
    this.u.put("Verizon Communications Inc", new String("verizon_communications_inc"));
    this.u.put("Walgreens", new String("walgreen_company"));
    this.u.put("Wells Fargo", new String("wells_fargo_and_company"));
    this.u.put("Williams Companies", new String("williams_companies"));
    this.u.put("Wal-Mart", new String("wal_mart_stores_inc"));
    this.u.put("Weyerhauser Co", new String("weyerhaeuser_company"));
    this.u.put("Exxon Mobil Corp", new String("exxon_mobil_corporation"));
    this.u.put("Xerox Corp", new String("xerox_corporation"));

    this.company = company;
    for (String a : company)
      this.companyUrl.add(String.format("http://topics.nytimes.com/topics/news/business/companies/%s/index.html", new Object[] { this.u.get(a) }));
  }

  public ArrayList<String> getUrl(String[] a)
  {
    return this.companyUrl;
  }

  public ArrayList<String> getUrl() {
    return this.companyUrl;
  }

  public ArrayList<String> getCompany()
  {
    ArrayList<String> company = new ArrayList<String>();
    Iterator<String> it = this.u.keySet().iterator();

    while (it.hasNext()) {
      String current = (String)it.next();
      company.add((String)this.u.get(current));
    }
    return company;
  }
}