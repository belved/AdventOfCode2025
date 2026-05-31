package model.Day8;

import java.util.Arrays;
import java.util.stream.IntStream;

public class UnionFind {
    int[] parent;
    int[] size;

    UnionFind(int n) {
        parent = IntStream.range(0, n).toArray();
        size = new int[n];
        Arrays.fill(size, 1);
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }

    int getSize(int x) {
        return size[x];
    }
}