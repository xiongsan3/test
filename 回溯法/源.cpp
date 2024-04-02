#include <iostream>
#define N 8

int moveX[8] = { 2, 1, -1, -2, -2, -1, 1, 2 };
int moveY[8] = { 1, 2, 2, 1, -1, -2, -2, -1 };

bool isSafe(int x, int y, int sol[N][N]) {
    return (x >= 0 && x < N&& y >= 0 && y < N&& sol[x][y] == -1);
}

void printSolution(int sol[N][N]) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            std::cout << sol[i][j] << "\t";
        }
        std::cout << std::endl;
    }
}

bool solveKTUtil(int x, int y, int movei, int sol[N][N]) {
    if (movei == N * N) {
        return true;
    }

    for (int k = 0; k < 8; k++) {
        int nextX = x + moveX[k];
        int nextY = y + moveY[k];

        if (isSafe(nextX, nextY, sol)) {
            sol[nextX][nextY] = movei;

            if (solveKTUtil(nextX, nextY, movei + 1, sol)) {
                return true;
            }
            else {
                sol[nextX][nextY] = -1;
            }
        }
    }

    return false;
}

void solveKT() {
    int sol[N][N];

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            sol[i][j] = -1;
        }
    }

    int startX, startY;
    std::cout << "��������ʼλ�õ������꣨0-7����";
    std::cin >> startX;
    std::cout << "��������ʼλ�õ������꣨0-7����";
    std::cin >> startY;

    sol[startX][startY] = 0;

    if (solveKTUtil(startX, startY, 1, sol)) {
        std::cout << "�ҵ����������" << std::endl;
        printSolution(sol);
    }
    else {
        std::cout << "�޷��ҵ����������" << std::endl;
    }
}

int main() {
    solveKT();

    return 0;
}