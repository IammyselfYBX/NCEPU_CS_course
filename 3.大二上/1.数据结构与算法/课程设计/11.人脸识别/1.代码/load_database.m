%?2019 YangBingxue Inc. All rights reserved
function output_value = load_database();
persistent loaded;
persistent numeric_Image;
if(isempty(loaded))
    all_Images = zeros(10304,400);%我们有400张图片。它们每个都有92 x 112 = 10304像素。
    for i=1:40
        cd(strcat('s',num2str(i)));
        for j=1:10
            image_Container = imread(strcat(num2str(j),'.pgm'));
            %imgray = rgb2gray(imdata);
            all_Images(:,(i-1)*10+j)=reshape(image_Container,size(image_Container,1)*size(image_Container,2),1);
        end
        display('Doading Database');
        cd ..
    end
    numeric_Image = uint8(all_Images);
end
loaded = 1;
output_value = numeric_Image;