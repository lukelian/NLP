fid = fopen('law_fusai.txt','w+');
[r,c] = size(Pre_Labels);
for i = 1:1:c
    for j = 1:1:r
        if Pre_Labels(j,i)==1
            fprintf(fid, '%d ', j);
        end
    end
    fprintf(fid, '\n');
end
fclose(fid);