package backend;

public class Search {

    public static Position findPosition(String[][] envState, String id)
    {
        int coordX =-1;
        int coordY =-1;
        boolean positionFinded = false;
        for (int i = 0; i < envState.length && !positionFinded; i++) {
            for (int j = 0; j < envState[i].length && !positionFinded; j++) {

                if(envState[i][j].equalsIgnoreCase(id))
                {
                    coordX =i;
                    coordY =j;
                    positionFinded = true;
                }
                
            }
        }

        return new Position(coordX,coordY);


    }

    
}
