package utilz;

public class Constants {
    
    public static class Directtions{
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class PlayerConstant{
        public static final int RUNNING1 = 0;
        public static final int RUNNING2 = 1;
        public static final int IDLE = 2;
        public static final int JUMPING = 3;
        public static final int FALLING = 4;
        public static final int TAKEHIT = 5;
        public static final int ATTACKING1 = 6;
        public static final int ATTACKING2 = 7;
        public static final int DEATH = 8;

        public static int GetSpritesAmount(int player_action){
            switch(player_action){
                case RUNNING1:
                case RUNNING2:
                    return 8;
                case IDLE:
                    return 8;
                case JUMPING:
                    return 2;
                case FALLING:
                    return 2;
                case TAKEHIT:
                    return 4;
                case ATTACKING1:
                case ATTACKING2:
                    return 6;
                case DEATH:
                    return 6;
                default:
                    return 0;
            }

        }

    }

}
