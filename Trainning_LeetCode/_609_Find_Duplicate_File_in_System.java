/**
 * https://leetcode.com/problems/find-duplicate-file-in-system/
 * Level: M
 * Tags: #string #map
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _609_Find_Duplicate_File_in_System {

    // key: File Content
    // Value: List of file that have the same file contents
    Map<String, List<String>> myMap = new HashMap<>();

    public void handleFolder(String folderInfo)
    {
        String[] data = folderInfo.split(" ");
        String folder = data[0];
        for (int i = 1; i < data.length; i++) {
            String fileInfo = data[i];
            int index = fileInfo.indexOf("(");
            String fileName = fileInfo.substring(0, index);
            String content = fileInfo.substring(index+1, fileInfo.length()-1);
            String fullFilePath = folder+"/"+fileName;

            if(myMap.containsKey(content) == true)
            {
                List<String> list = myMap.get(content);
                list.add(fullFilePath);
            }
            else
            {
                List<String> list = new ArrayList<>();
                list.add(fullFilePath);
                myMap.put(content, list);
            }
        }
    }

    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < paths.length; i++) {
            handleFolder(paths[i]);
        }

        for (Map.Entry e : myMap.entrySet()) {
            List<String> files = (List<String>)e.getValue();
            if(files != null && files.size() > 1){
                result.add(files);
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
