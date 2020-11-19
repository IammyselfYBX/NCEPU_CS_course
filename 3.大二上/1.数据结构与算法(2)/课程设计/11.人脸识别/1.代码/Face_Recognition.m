%©2019  YangBingxue Inc. All rights reserved
%Viseron 1.0.1

loaded_Image=load_database();
random_Index=round(400*rand(1,1));
random_Image=loaded_Image(:,random_Index);
rest_of_the_images=loaded_Image(:,[1:random_Index-1 random_Index+1:end]);
image_Signature=20;% KNN算法 通常k是不大于20的整数
white_Image=uint8(ones(1,size(rest_of_the_images,2)));
mean_value=uint8(mean(rest_of_the_images,2));
mean_Removed=rest_of_the_images-uint8(single(mean_value)*single(white_Image));
L=single(mean_Removed)'*single(mean_Removed);%求协方差矩阵
[V,D]=eig(L);%求协方差矩阵的特征值
V=single(mean_Removed)*V;
V=V(:,end:-1:end-(image_Signature-1));
all_image_Signatire=zeros(size(rest_of_the_images,2),image_Signature);

for i=1:size(rest_of_the_images,2);
    all_image_Signatire(i,:)=single(mean_Removed(:,i))'*V;
end
subplot(121);
imshow(reshape(random_Image,112,92));
title('Looking for this Face','FontWeight','bold','Fontsize',16,'color','red');
subplot(122);
p=random_Image-mean_value;
s=single(p)'*V;
z=[];

for i=1:size(rest_of_the_images,2)
    z=[z,norm(all_image_Signatire(i,:)-s,2)];
    if(rem(i,20)==0),imshow(reshape(rest_of_the_images(:,i),112,92)),end;
    drawnow;
end
[a,i]=min(z);
subplot(122);
imshow(reshape(rest_of_the_images(:,i),112,92));
title('Recognition Completed','FontWeight','bold','Fontsize',16,'color','red');