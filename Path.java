public class Path {
    private String path;
    public Path(String path) {
        this.path = path;
    }
    
    public String getPath() {
        return path;
    }
    
    public Path cd(String newPath) {
        Path pathStr = new Path(this.path);

        if(newPath == null){
             throw new UnsupportedOperationException("Waiting to be implemented.");
        }
        else{
            if (newPath.matches("([\\.]{2}/)+[a-zA-z]+")){
                String[] replaceDir = newPath.split("[\\.]{2}"); //stone the string of directory

                System.out.println("Match!");
                for(int i=1; i<replaceDir.length; i++){
                    if(replaceDir[i].matches("/")){
                        try{
                            pathStr.path = pathStr.getPath().substring(0, pathStr.getPath().length()-2);
                        }catch(StringIndexOutOfBoundsException e){
                            System.out.println("This is the root path");
                            System.out.println(e.getMessage());
                            break;
                        }
                    }
                    else{
                        pathStr.path = pathStr.getPath() + replaceDir[i];
                    }
                    System.out.println(pathStr.path);
                    System.out.println(replaceDir[i]+i);

                }
               

            }else{
                System.out.println("not match");
            }

            /*first split the string by using "/" charater
            store into the array
            use switch to decide to which action should do
            have an exception if the value in array is not the English alphabet
            (use 'reguler expression')
            should be note that the return value should also be Path object
            */

            /*
                switch(temp){
                    case "..":
                        Path = path.delete(....)
                    case "":

                }
            */

        }
        return pathStr;
    }
    
    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        System.out.println(path.cd("../x").getPath());
    } 
}