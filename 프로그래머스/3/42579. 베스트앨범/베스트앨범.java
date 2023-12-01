import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();    // 장르, 판매량 총합
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 판매량별 장르 내림차순 정렬
        ArrayList<String> genreList = new ArrayList<>();
        for (String key : map.keySet()) {
            genreList.add(key);
        }
        Collections.sort(genreList, (o1, o2) -> map.get(o2) - map.get(o1));

        // 장르별 노래 넣기
        for (String genre : genreList) {
            ArrayList<int[]> list = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i])) {
                    list.add(new int[]{i, plays[i]});
                }
            }

            Collections.sort(list, (o1, o2) -> {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                else return o2[1] - o1[1];
            });

            // 사이즈 체크
            answer.add(list.get(0)[0]);
            if (list.size() > 1) answer.add(list.get(1)[0]);
        }
        
        return answer;
    }
}