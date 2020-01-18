package org.guo.leetCode;

public class StreamTest {

    public static void main(String[] args) {
//        IntStream.range(1, 5).forEach(System.out::println);
//        System.out.println("================================================");
//        System.out.println(IntStream.rangeClosed(1, 100).filter(n -> n%2!=0).reduce(Integer::sum).getAsInt());
//        System.out.println(IntStream.rangeClosed(1, 100).filter(n -> n%2==0).reduce(Integer::sum).getAsInt());
//        System.out.println("================================================");
//        Stream<List<Integer>> inputStream = Stream.of(
//                Arrays.asList(1),
//                Arrays.asList(2, 3),
//                Arrays.asList(4, 5, 6)
//        );
//        Stream<Integer> outputStream = inputStream.flatMap(childList -> childList.stream());//.forEach(System.out::println);

//        IntStream.rangeClosed(1, 10).filter(n -> n%2==0).skip(3).forEach(System.out::println);
//        Stream.iterate(1, n -> n+2).limit(10).forEach(System.out::println);


//        String input = "Let's take LeetCode contest";
//        System.out.println(Stream.of(input.split(" ")).map(str -> {
//            StringBuilder sb = new StringBuilder();
//            for(int i = str.length(); i > 0; i--) {
//                sb.append(str.charAt(i-1));
//            }
//            return sb.toString();
//        }).reduce((a, b) -> a + " " + b).get());


//        int[] candies = new int[]{1,1,2,2,3,3};
//
//        int distinct = (int)IntStream.of(candies).distinct().count();
//        System.out.println(candies.length/2 > distinct ? distinct : candies.length/2);

        /*int[] nums = {2, 7, 11, 15};
        int target = 9;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.size() == 0) map.put(nums[i], i);
            int key = target - nums[i];
            if(map.containsKey(key)) return new int[]{map.get(key), i};
            else map.put(nums[i], i);
        }*/

    }


}
