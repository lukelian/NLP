function [result_maxValue, result_locate] = Validation(train_data_input,train_target_input,starts,ends)
[r,c] = size(train_data_input);
train_data = train_data_input(1:r/2,:);
test_data = train_data_input(r/2+1:r,:);
train_target = train_target_input(:,1:r/2);
test_target = train_target_input(:,r/2+1:r);
HammingLoss = zeros(100);
RankingLoss = zeros(100);
OneError = zeros(100);
Coverage = zeros(100);
Average_Precision = zeros(100);
Outputs = zeros(100);
Pre_Labels = zeros(100);

for i = starts:1:ends
    [Prior,PriorN,Cond,CondN]=MLKNN_train(train_data,train_target,i,0.01);
%    [HammingLoss(i),RankingLoss(i),OneError(i),Coverage(i),Average_Precision(i),Outputs(i),Pre_Labels(i)]=MLKNN_test(train_data,train_target,test_data,test_target,i,Prior,PriorN,Cond,CondN);
    [HammingLoss,RankingLoss,OneError,Coverage,Average_Precision(i)]=MLKNN_test(train_data,train_target,test_data,test_target,i,Prior,PriorN,Cond,CondN);
end

[maxValue, locate] = max(Average_Precision);
result_maxValue = maxValue;
result_locate = locate + starts - 1;