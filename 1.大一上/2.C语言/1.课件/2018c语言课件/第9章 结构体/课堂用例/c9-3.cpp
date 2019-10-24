#include <stdio.h>
#include <math.h>

struct point makepoint(int, int);
void MakeRect(struct point pt1, struct point, struct point, struct point, struct rect);
int PtInRect(struct point p, struct rect r);

/*the define of point structure*/
struct point{
  float x;
  float y;
};

/*the define of rectangular structure*/
struct rect{
   struct point  pt1;
   struct point  pt2;
   struct point  pt3;
   struct point  pt4;
};

/* make a point  */
struct point MakePoint(int x, int y)
{
   struct point temp; 
   temp.x = x;
   temp.y = y; 
   return temp;
}

/*make a rectangular */
void MakeRect(struct point pt1, struct point pt2, struct point pt3, struct point pt4, struct rect *screen)
{
   (*screen).pt1 = pt1;
   (*screen).pt2 = pt2;
   (*screen).pt3 = pt3;
   (*screen).pt4 = pt4;
}

/* return 1 if p in r, 0 if not */
int PtInRect(struct point p, struct rect r)
{
	return p.x >= r.pt1.x && p.x < r.pt2.x
           && p.y >= r.pt1.y && p.y < r.pt3.y;
}

void main()
{
    struct point pt1 = MakePoint(0,0);
	struct point pt2 = MakePoint(50,0);
    struct point pt3 = MakePoint(50, 10);
	struct point pt4 = MakePoint(0,10);

    struct rect screen;
	MakeRect(pt1,pt2,pt3,pt4,&screen);

    struct point middle = MakePoint((screen.pt1.x + screen.pt2.x)/2,
             (screen.pt1.y + screen.pt4.y)/2); 
    printf("\nThe middle point of the screen is (%.1f,%.1f)\n",middle.x,middle.y);

	if(PtInRect(middle,screen))
	    printf("\nThe middle point is in screen!\n");
	else
		printf("\nThe middle point is not in screen!\n");

}
