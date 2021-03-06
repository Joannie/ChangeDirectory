import java.util.regex.Pattern;
import java.util.regex.Matcher;

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

        //Check if the path is not empty or null
        if(newPath == null | newPath == ""){
             throw new UnsupportedOperationException("Waiting to be implemented.");
        }
        else{
            /*Check the input is a correct format. 
            Should contian the parent dir and path separator and dir name
*           */
            if (newPath.matches("([\\.]{2}/)+[a-zA-z]+")){
                Pattern reg = Pattern.compile("/([a-zA-z]*)");//Split the input str by slash or slash plus english alphabet letters
                Matcher m = reg.matcher(newPath); //mathch this reg pattern with input str  

                while(m.find()){
                    //System.out.println(m.group());
                    
                    /*If found the group contians the slash, then should remove the last one path*/
                    if(m.group().matches("/")){
                        try{
                            pathStr.path = pathStr.getPath().substring(0, pathStr.getPath().length()-2);
                            //System.out.println("the path: " + pathStr.path);
                        }catch(StringIndexOutOfBoundsException e){
                            System.out.println("Please check your input. Is the correct syntax for changing the directory?");
                            System.out.println(e.getMessage());
                            break;
                        }                  
                    }

                    /*Else, should remove last one and replace to the dir name*/
                    else{
                        try{
                            pathStr.path = pathStr.getPath().substring(0, pathStr.getPath().length()-2);
                            pathStr.path = pathStr.getPath() + m.group();
                        }catch(StringIndexOutOfBoundsException e){
                            System.out.println("Your directory is beyond the root dir. Please type again!");
                            System.out.println(e.getMessage());
                            break;
                        }

                    }

                }

            }else{
                System.out.println("Please check your input. Is the correct syntax for changing the directory?");
            }
        }
        return pathStr;
        
    }
    
    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        System.out.println(path.cd("../x").getPath());
    } 
}