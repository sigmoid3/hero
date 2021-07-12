package old.str;

class DeleteRepeat {
    public int removeDuplicates1(int[] nums) {
        int len = nums.length;
        if(len==0){
            return 0;
        }
        int cnt = 0;
        for(int i=1;i<len;i++){
            if(nums[i]!=nums[cnt]){
                cnt++;
                nums[cnt] = nums[i];
            }
        }
        return cnt+1;
    }

    public int removeDuplicates2(int[] num){
        int i=num.length==0?0:1;
        for(int n:num){
            if(n>num[i-1]) {
                num[i++] = n;
            }
        }
        return i;
    }
}