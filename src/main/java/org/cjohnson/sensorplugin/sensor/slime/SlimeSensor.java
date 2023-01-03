package org.cjohnson.sensorplugin.sensor.slime;

import org.bukkit.Chunk;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.Objects;

public class SlimeSensor {
    private int rangeChunks;
    private boolean[][] slimeMatrix;
    private ArrayList<Chunk> slimeChunks;

    @Deprecated
    public SlimeSensor(int rangeChunks) {
        this.rangeChunks = rangeChunks;
        this.slimeMatrix = new boolean[(2 * rangeChunks) + 1][(2 * rangeChunks) + 1];
        slimeChunks = new ArrayList<>();
    }

    public SlimeSensor() {

    }

    public ArrayList<Chunk> sample(Location location, int range) {
        if(location == null) throw new IllegalArgumentException("Provided location was null.");
        ArrayList<Chunk> result = new ArrayList<>();

        int rangeSize = (2 * range) + 1;

        int chunkX = location.getBlockX() >> 4;
        int chunkZ = location.getBlockZ() >> 4;

        int pointerI, pointerJ, pointerX, pointerZ;
        Chunk pointerChunk;
        for(int i = 0; i < rangeSize; i++) {
            for(int j = 0; j < rangeSize; j++) {
                pointerI = i - range;
                pointerJ = j - range;

                pointerX = chunkX + pointerI;
                pointerZ = chunkZ + pointerJ;

                pointerChunk = Objects.requireNonNull(location.getWorld()).getChunkAt(pointerX, pointerZ);
                if(pointerChunk.isSlimeChunk()) result.add(pointerChunk);
            }
        }

        return result;
    }

    @Deprecated
    public void sample(Location location) {
        if(location == null) throw new IllegalArgumentException("Provided location was null.");
        slimeChunks.clear();

        int chunkX = location.getBlockX() >> 4;
        int chunkZ = location.getBlockZ() >> 4;

        int pointerI, pointerJ, pointerX, pointerZ;
        Chunk pointerChunk;
        for(int i = 0; i < slimeMatrix.length; i++) {
            for(int j = 0; j < slimeMatrix[i].length; j++) {
                pointerI = i - rangeChunks;
                pointerJ = j - rangeChunks;

                pointerX = chunkX + pointerI;
                pointerZ = chunkZ + pointerJ;

                pointerChunk = Objects.requireNonNull(location.getWorld()).getChunkAt(pointerX, pointerZ);
                slimeMatrix[i][j] = pointerChunk.isSlimeChunk();
                if(pointerChunk.isSlimeChunk()) slimeChunks.add(pointerChunk);
            }
        }
    }

    @Deprecated
    public ArrayList<Chunk> getSlimeChunks() {
        return slimeChunks;
    }
}
