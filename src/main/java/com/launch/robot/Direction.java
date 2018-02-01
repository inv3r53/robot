package com.launch.robot;

public enum Direction {
    EAST(1,0){
        @Override
        public Direction right() {
            return SOUTH;
        }

        @Override
        public Direction left() {
            return NORTH;
        }
    }, WEST(-1,0){
        @Override
        public Direction right() {
            return NORTH;
        }

        @Override
        public Direction left() {
            return SOUTH;
        }
    }
    ,NORTH(0,1){
        @Override
        public Direction right() {
            return EAST;
        }

        @Override
        public Direction left() {
            return WEST;
        }
    },
    SOUTH(0,-1){
        @Override
        public Direction right() {
            return WEST;
        }

        @Override
        public Direction left() {
            return EAST;
        }
    };
    private int x;

    public abstract Direction right();
    public abstract Direction left();

    private int y;
    private Direction right;
    private Direction left;
    private Direction(int x,int y ){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
