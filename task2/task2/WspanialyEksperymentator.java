import java.util.*;

class WspanialyEksperymentator implements Eksperymentator{
    private KostkaDoGry kostka;
    private long czasEksperymentu;
    @Override
    public void użyjKostki(KostkaDoGry kostka) {
        this.kostka = kostka;
    }

    @Override
    public void czasJednegoEksperymentu(long czasEksperymentu) {
        this.czasEksperymentu = czasEksperymentu;
    }

    @Override
    public Map<Integer, Double> szansaNaWyrzucenieOczek(int liczbaKostek) {
        Map<Integer,Double> result = new HashMap<>();
        int sum = 0;
        int throwCount = 0;
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<czasEksperymentu){
            for(int i=0;i<liczbaKostek;i++){
                sum+=kostka.rzut();
            }
            if(result.containsKey(sum)){
                result.put(sum,result.get(sum)+1);
            }else{
                result.put(sum,1.0);
            }
            sum=0;
            throwCount++;
        }
        for(Integer key:result.keySet()){
            result.put(key,result.get(key)/throwCount);
        }
        return result;
    }

    @Override
    public double szansaNaWyrzucenieKolejno(List<Integer> sekwencja) {
        int tries = 0;
        int success = 0;
        int throwResult;
        List<Integer> results = new ArrayList<>();
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<czasEksperymentu){
            for(Integer eyelet:sekwencja){
                throwResult = kostka.rzut();
                if(throwResult==eyelet){
                    results.add(throwResult);
                }
            }
            if(results.equals(sekwencja)){
                success++;
            }
            results.clear();
            tries++;
        }
        return (double)success/tries;
    }

    @Override
    public double szansaNaWyrzucenieWDowolnejKolejności(Set<Integer> oczka) {
        int success = 0;
        int tries = 0;
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<czasEksperymentu){
            Set<Integer> results = new HashSet<>();
            for(int i=0;i<oczka.size();i++)
            {
                results.add(kostka.rzut());
            }
            if(results.containsAll(oczka)){
                success++;
            }
            tries++;
        }
        return (double)success/tries;
    }
}
