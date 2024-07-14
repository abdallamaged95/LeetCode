class Solution {
    public boolean hasGroupsSizeX(int[] deck)
    {
        List<Integer> primes = generatePrimes();
        Map<Integer,Integer> groups = initGroups(deck);

        for (int prime : primes)
        {
            boolean flag = true;
            for (Map.Entry<Integer, Integer> entry : groups.entrySet())
            {
                if (entry.getValue() % prime != 0)
                {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return true;
        }

        return false;
    }

    public Map<Integer, Integer> initGroups(int[] deck)
    {
        Map<Integer, Integer> x = new HashMap<>();
        for (int i = 0; i < deck.length; i++)
        {
            if (x.containsKey(deck[i]))
                x.put(deck[i], x.get(deck[i]) + 1);
            else
                x.put(deck[i], 1);
        }
        return x;
    }
    public List<Integer> generatePrimes()
    {
        int[] p = new int[110];
        for (int i = 0; i < p.length; i++)
            p[i] = i;

        p[0] = p[1] = -1;
        for (int i = 2; i < p.length; i++)
        {
            if (p[i] != -1)
                for (int j = i*2; j < p.length; j+=i)
                    p[j] = -1;
        }
        List<Integer> primes = new ArrayList<>();
        for (int j : p)
            if (j != -1)
                primes.add(j);

        return primes;
    }
}