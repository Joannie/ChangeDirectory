public class Path {
    private String path;
    public Path(String path) {
        this.path = path;
    }
    
    public String getPath() {
        return path;
    }
    
    public Path cd(String newPath) {
            /*Use regular expression to match the string to what we want
            and bring replace the original string by string analysis based on the Notes
            Current bug: The first parent directory can't be parse sucessfully
            */
        Path pathStr = new Path(this.path);

        if(newPath == null){
             throw new UnsupportedOperationException("Waiting to be implemented.");
        }
        else{
            if (newPath.matches("([\\.]{2}/)+[a-zA-z]+")){
                String[] replaceDir = newPath.split("[\\.]{2}"); //stone the string of directory

                //System.out.println("Match!");
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
                    //System.out.println(pathStr.path);
                    //System.out.println(replaceDir[i]+i);

                }               

            }else{
                System.out.println("Please check your input on changning directory!");
            }

        }
        return pathStr;
    }
    
    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        System.out.println(path.cd("../x").getPath());
    } 
}