#coding:utf-8
import numpy as np
import datetime
from sklearn import svm
from sklearn.cross_validation import train_test_split
from matplotlib.pyplot import axis
starttime = datetime.datetime.now()
pathTrain = u'C:/Users/ssh32/Desktop/cff/newtfidf/BDCI/tfidf5000.txt'
pathTest = u'C:/Users/ssh32/Desktop/cff/newtfidf/BDCI/tfidfTestTemp.txt'
input_fileTest = open("C:/Users/ssh32/Desktop/cff/newtfidf/BDCI/penalize.txt","a")
trainData = np.loadtxt(pathTrain, dtype=float)
x_test = np.loadtxt(pathTest, dtype=float)

x_train, y_train = np.split(trainData, (4076,), axis=1)
#
x_train, x_test, y_train, y_test = train_test_split(x_train, y_train, random_state=1, train_size=0.8)
#clf = svm.SVC(C=0.2, kernel='linear', decision_function_shape='ovr')
#clf = svm.SVC(C=0.8, kernel='rbf', gamma=20, decision_function_shape='ovr')0.381666666667
clf = svm.SVC(C=0.8, kernel='poly', gamma=200, decision_function_shape='ovr')
clf.fit(x_train, y_train.ravel())
print (clf.score(x_train, y_train))

y_hat1 = clf.predict(x_train)
y_hat2 = clf.predict(x_test)
print (clf.score(x_test, y_test))

for i in y_hat2:
     input_fileTest.write(str(int(i))+"\t\n")
endtime = datetime.datetime.now()
print (endtime - starttime).seconds