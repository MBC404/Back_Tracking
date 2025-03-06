class CombinationSUM_Solution {
    public void makeCombination(int arr[],int target,List<Integer> cur,List<List<Integer>> res,int index)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(cur));
            return;
        }
        if(target < 0 ||  index >= arr.length )
        {
            return;
        }
        cur.add(arr[index]);
        makeCombination(arr,target-arr[index],cur,res,index);
        cur.remove(cur.size()-1);
        makeCombination(arr,target,cur,res,index+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        makeCombination(candidates,target,cur,res,0);
        return res;
    }
}