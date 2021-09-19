import java.io.*;
import java.util.*;

public class BOJ_21609_SharkMiddleSchool {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int score;
    private static List<BlockInfo> blockInfoList;

    static class BlockInfo{
        int stdR, stdC;
        int rainbowCnt;
        List<int[]> list = new LinkedList<>(); // 모든 블록을 담을 리스트

        public void setStdR(int stdR, int stdC) {
            this.stdR = stdR;
            this.stdC = stdC;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행렬 크기
        M = Integer.parseInt(st.nextToken()); // 블록 최대 수

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }// 배열 입력 받기

        boolean isGroupPresent = false;
        while (true) {
            boolean[][] visited = new boolean[N][N]; // 방문 체크 배열
            blockInfoList = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int stdNum = map[i][j];
                    boolean[][] tmpVisited = new boolean[N][N];
                    if (!visited[i][j] && stdNum != -1 && stdNum!=-2) {
                        BlockInfo blockInfo = new BlockInfo();
                        boolean flag = false;
                        flag = makeGroups(flag, visited, tmpVisited, blockInfo, i, j, stdNum);
                        if (blockInfo.list.size() > 1 && flag) { // block group이 형성된다는 뜻
                            setStdBlock(blockInfo); // 기준 블록 설정
                            blockInfoList.add(blockInfo);
                        }
                    }
                }
            }// 그룹 만들기
            if (blockInfoList.size() == 0) break;

            BlockInfo blockInfo = findTarget(blockInfoList); // 터뜨릴 블록 그룹 찾기
            bomb(blockInfo);
            gravity(); // 중력 작용시키기
            turn(); // 90도 반시계 방향 회전
            gravity(); // 중력 작용
        }
        System.out.println(score);
    }//Main

    private static int[] dirR = {-1, 0, 1, 0};
    private static int[] dirC = {0, -1, 0, 1};

    private static boolean makeGroups(boolean flag, boolean[][] visited, boolean[][] tmpvisited, BlockInfo blockInfo, int r, int c, int stdNum) {
        int curBlock = map[r][c];
        if (curBlock != 0) {
            visited[r][c] = true; // 전체 범위 방문 처리
        }
        tmpvisited[r][c] = true;
        blockInfo.list.add(new int[]{r, c}); // 블록 저장
        if (map[r][c] == 0) {
            blockInfo.rainbowCnt++;
        } else {
            flag = true;
        }

        for (int d = 0; d < 4; d++) {
            int nr = dirR[d] + r;
            int nc = dirC[d] + c;
            if (0 <= nr && nr < N && 0 <= nc && nc < N && !tmpvisited[nr][nc] && (map[nr][nc] == stdNum || map[nr][nc] == 0)) {
                makeGroups(flag, visited, tmpvisited, blockInfo, nr, nc, stdNum);
            }
        }
        return flag;
    }// 그룹 정보 저장

    private static void setStdBlock(BlockInfo blockInfo){
        List<int[]> list = blockInfo.list;
        int r = N; int c = N;

        for (int i = 0, size=list.size(); i < size; i++) {
            int[] bList = list.get(i);
            int cr = bList[0]; int cc = bList[1];
            int cur = map[cr][cc];
            if(map[cr][cc] != 0 && (cr<r || (cr==r && cc<c))) { r=cr; c=cc; }
        }
        blockInfo.setStdR(r,c);
    }// 기준 블록 설정

    private static BlockInfo findTarget(List<BlockInfo> blockInfoList) {
        BlockInfo blockInfo = blockInfoList.get(0); // 터뜨릴 그룹
        int maxSize=blockInfo.list.size();
        int stdR = blockInfo.stdR;
        int stdC = blockInfo.stdC;

        for (int i = 0, size = blockInfoList.size(); i < size; i++) {
            BlockInfo curBlockInfo = blockInfoList.get(i);
            if (curBlockInfo.list.size() > maxSize) {
                blockInfo = curBlockInfo; maxSize = curBlockInfo.list.size(); stdR = curBlockInfo.stdR; stdC = curBlockInfo.stdC;
            } else if (curBlockInfo.list.size() == maxSize) { // 사이즈가 같다면,
                if (curBlockInfo.rainbowCnt > blockInfo.rainbowCnt) { // 무지개 블록이 더 많은 것.
                    blockInfo = curBlockInfo; maxSize = curBlockInfo.list.size(); stdR = curBlockInfo.stdR; stdC = curBlockInfo.stdC;
                } else if (curBlockInfo.rainbowCnt == blockInfo.rainbowCnt) { // 무지개 블록 수가 같다면,
                    if (curBlockInfo.stdR > blockInfo.stdR) { // 기준 블록의 행이 더 큰 것.
                        blockInfo = curBlockInfo; maxSize = curBlockInfo.list.size(); stdR = curBlockInfo.stdR; stdC = curBlockInfo.stdC;
                    } else if (curBlockInfo.stdR == blockInfo.stdR) { // 기준 블록의 행이 같다면,
                        if (curBlockInfo.stdC > blockInfo.stdC) { // 기준 블록의 열이 더 큰 것.
                            blockInfo = curBlockInfo; maxSize = curBlockInfo.list.size(); stdR = curBlockInfo.stdR; stdC = curBlockInfo.stdC;
                        }
                    }
                }
            }
        }
        return blockInfo;
    }// 터뜨릴 블록 그룹 찾기

    private static void bomb(BlockInfo curBlockInfo){
        List<int[]> list = curBlockInfo.list;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int[] arr = list.get(i);
            map[arr[0]][arr[1]] = -2; // 터뜨리기
        }
        score += (size*size);
    }// 블록 그룹 터뜨리기(점수 획득)

    private static void gravity() {
        for (int j = 0; j < N; j++) { // 열을 하나씩 돌리면서 중력 작용시키기
        int space = -3; // 이동시킬 위치(없는 경우: -3)
        boolean flag = false; // 지정된 space가 없음
            for (int i = N-1; i>=0; i--) {
                if (map[i][j] == -2 && !flag) {
                    space = i; flag = true;
                } else if (map[i][j] == -1){ // 검은색 블록인 경우 이동시킬 위치 리셋
                    space = -3;
                    flag = false;
                } else if (map[i][j] >= 0) { // 일반 또는 무지개 블록인 경우
                    if(space != -3) { // 이동시킬 위치가 있다면
                        map[space][j] = map[i][j];
                        map[i][j] = -2;
                        space = space-1;
                        flag = true;
                    }
                }
                }
            }
    }// 중력 반영

    private static void turn() {
        int[][] newMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newMap[N-1-j][i] = map[i][j];
            }
        }
        map = newMap;
    }// 배열 90도 회전

}//Class
