class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        int block_size = (int) Math.floor(Math.sqrt(n));
        int num_blocks = (n + block_size - 1) / block_size;

        int [] perBlockMax = new int[num_blocks];
        for(int i=0; i<n; i++){
            int b = i / block_size;
            perBlockMax[b] = Math.max(perBlockMax[b], baskets[i]);
        }

        int unplaced = 0;

        for(int i=0; i<n; i++){
            int fruit = fruits[i];
            int block_index = -1;

            for(int b=0; b<num_blocks; b++){
                if(perBlockMax[b] >= fruit){
                    block_index = b;
                    break;
                }
            }

            if(block_index == -1){
                unplaced += 1;
                continue;
            }

            boolean isPlaced = false;
            int start = block_index * block_size;
            int end = Math.min(n, (block_index + 1) * block_size);

            for(int j=start; j<end; j++){
                if(baskets[j] >= fruit){
                    baskets[j] = 0;
                    isPlaced = true;
                    break;
                }
            }

            int max = Integer.MIN_VALUE;

            for(int j=start; j<end; j++){
                max = Math.max(max, baskets[j]);
                perBlockMax[block_index] = max;
            }

            if(!isPlaced){
                unplaced += 1;
            }
        }

        return unplaced;
    }
}