#include <windows.h>
#include <stdio.h>

void os() {
	printf("Hey, I'm Windows!\n");
	while (true) {}
} 

LRESULT CALLBACK WndProc(HWND, UINT, WPARAM, LPARAM);

LPCSTR lpszAppName = "AppName";
LPCSTR lpszTitle   = "Meine erste Applikation";

int APIENTRY WinMain(HINSTANCE hInstance,
           HINSTANCE hPrevInstance, PSTR szCmdLine, int iCmdShow)
{
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
   }
   return DefWindowProc(hWnd, umsg, wParam, lParam);
}