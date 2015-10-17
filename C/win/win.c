#include <windows.h>
#include <stdio.h>

void os() {
	printf("Hey, I'm Windows!\n");
} 

LRESULT CALLBACK WndProc(HWND, UINT, WPARAM, LPARAM);

LPCSTR lpszAppName = "AppName";
LPCSTR lpszTitle   = "Meine erste Applikation";

int APIENTRY WinMain(HINSTANCE hInstance,
           HINSTANCE hPrevInstance, PSTR szCmdLine, int iCmdShow)
{
	
	int i = 0;
	int j = 1;
	int result = i + j;
	printf("Result is %d\n", result);
	printf("Finished\n");
	printf("Starting inline asm\n");
	int src = 1;
	int src2= 2;
    int dst;
     
	 //"mov %2, %0\n\t"
	 //"add $3, %0\n\t"
	 //"add $3, %0\n\t"
	 //1
	 //"mov %%edx,%%esp\n\t"
	 //"sysenter\n\t"
	 //"ret\n\t"
	 //2
	 //"mov %%r10, %%rcx\n\t"
	 //"mov %%eax, 52\n\t" 
	 //"syscall \n\t"
	 //"ret\n\t"
	 //3
	 
	asm ("int $3\n\t"
		 "mov $0x19, %%eax\n\t"
         "int $0x2E\n\t"
		 : "=r" (dst)
		 : "r" (src), "r" (src2)
		 );
		 
	getchar();
     
    //printf("%d\n", dst);
	printf("Finished inline asm\n");

   HWND       hWnd;
   MSG        msg;
   WNDCLASSEX   wc;

   wc.cbSize        =  sizeof(WNDCLASSEX);
   wc.style         =  CS_HREDRAW | CS_VREDRAW;
   wc.lpfnWndProc   =  WndProc;
   wc.cbClsExtra    =  0;
   wc.cbWndExtra    =  0;
   wc.hInstance     =  hInstance;
   wc.hCursor       =  LoadCursor(NULL,IDC_ARROW);
   wc.hIcon         =  LoadIcon(NULL, IDI_APPLICATION);
   wc.hbrBackground =  (HBRUSH)GetStockObject(WHITE_BRUSH);
   wc.lpszClassName =  lpszAppName;
   wc.lpszMenuName  =  lpszAppName;
   wc.hIconSm       =  LoadIcon(NULL, IDI_APPLICATION);

   if( RegisterClassEx(&wc) == 0)
      return 0;

   hWnd = CreateWindowEx(NULL,
                         lpszAppName,
                         lpszTitle,
                         WS_OVERLAPPEDWINDOW,
                         0,
                         0,
                         CW_USEDEFAULT,
                         CW_USEDEFAULT,
                         NULL,
                         NULL,
                         hInstance,
                         NULL);

   if( hWnd == NULL)
      return 0;

   ShowWindow(hWnd, iCmdShow);
   UpdateWindow(hWnd);

   while (GetMessage(&msg, NULL, 0, 0) > 0)
   {
      TranslateMessage(&msg);
      DispatchMessage(&msg);
   }
   return msg.wParam;
}

LRESULT CALLBACK WndProc(HWND hWnd, UINT umsg, WPARAM wParam, LPARAM lParam)
{
   switch (umsg)
   {
		case WM_DESTROY:
		{
			PostQuitMessage(0);
			return 0;
		}
		case WM_MOVE:
		{
			printf("Fenster bewegt\n");
			return 0;
		}
   }
   return DefWindowProc(hWnd, umsg, wParam, lParam);
}