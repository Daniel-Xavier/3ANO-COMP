rivate int getValue(){
    Random rand = new Random();
    ArrayList<Integer> values = new ArrayList<>();
    values.add(10);
    values.add(20);
    values.add(50);
    values.add(100);

    return values.get(rand.nextInt(values.size()));
}