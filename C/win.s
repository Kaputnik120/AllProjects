	.file	"win.c"
	.text
.Ltext0:
	.cfi_sections	.debug_frame
	.section .rdata,"dr"
.LC0:
	.ascii "Hey, I'm Windows!\0"
	.text
	.globl	os
	.def	os;	.scl	2;	.type	32;	.endef
os:
.LFB1948:
	.file 1 "win/win.c"
	.loc 1 4 0
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$32, %rsp
	.loc 1 5 0
	leaq	.LC0(%rip), %rcx
	call	puts
	.loc 1 6 0
	leave
	.cfi_restore 6
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1948:
	.globl	lpszAppName
	.section .rdata,"dr"
.LC1:
	.ascii "AppName\0"
	.data
	.align 8
lpszAppName:
	.quad	.LC1
	.globl	lpszTitle
	.section .rdata,"dr"
.LC2:
	.ascii "Meine erste Applikation\0"
	.data
	.align 8
lpszTitle:
	.quad	.LC2
	.section .rdata,"dr"
.LC3:
	.ascii "Finished\0"
	.text
	.globl	WinMain
	.def	WinMain;	.scl	2;	.type	32;	.endef
WinMain:
.LFB1949:
	.loc 1 15 0
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$256, %rsp
	movq	%rcx, 16(%rbp)
	movq	%rdx, 24(%rbp)
	movq	%r8, 32(%rbp)
	movl	%r9d, 40(%rbp)
	.loc 1 17 0
	movl	$0, -4(%rbp)
	.loc 1 18 0
	movl	$1, -8(%rbp)
	.loc 1 19 0
	movl	-4(%rbp), %edx
	movl	-8(%rbp), %eax
	addl	%edx, %eax
	movl	%eax, -12(%rbp)
	.loc 1 20 0
	leaq	.LC3(%rip), %rcx
	call	printf
	.loc 1 26 0
	movl	$80, -160(%rbp)
	.loc 1 27 0
	movl	$515, -156(%rbp)
	.loc 1 28 0
	leaq	WndProc(%rip), %rax
	movq	%rax, -152(%rbp)
	.loc 1 29 0
	movl	$0, -144(%rbp)
	.loc 1 30 0
	movl	$0, -140(%rbp)
	.loc 1 31 0
	movq	16(%rbp), %rax
	movq	%rax, -136(%rbp)
	.loc 1 32 0
	movl	$32512, %edx
	movl	$0, %ecx
	movq	__imp_LoadCursorA(%rip), %rax
	call	*%rax
	movq	%rax, -120(%rbp)
	.loc 1 33 0
	movl	$32512, %edx
	movl	$0, %ecx
	movq	__imp_LoadIconA(%rip), %rax
	call	*%rax
	movq	%rax, -128(%rbp)
	.loc 1 34 0
	movl	$0, %ecx
	movq	__imp_GetStockObject(%rip), %rax
	call	*%rax
	movq	%rax, -112(%rbp)
	.loc 1 35 0
	movq	lpszAppName(%rip), %rax
	movq	%rax, -96(%rbp)
	.loc 1 36 0
	movq	lpszAppName(%rip), %rax
	movq	%rax, -104(%rbp)
	.loc 1 37 0
	movl	$32512, %edx
	movl	$0, %ecx
	movq	__imp_LoadIconA(%rip), %rax
	call	*%rax
	movq	%rax, -88(%rbp)
	.loc 1 39 0
	leaq	-160(%rbp), %rax
	movq	%rax, %rcx
	movq	__imp_RegisterClassExA(%rip), %rax
	call	*%rax
	testw	%ax, %ax
	jne	.L3
	.loc 1 40 0
	movl	$0, %eax
	jmp	.L8
.L3:
	.loc 1 42 0
	movq	lpszTitle(%rip), %rcx
	movq	lpszAppName(%rip), %rax
	movq	$0, 88(%rsp)
	movq	16(%rbp), %rdx
	movq	%rdx, 80(%rsp)
	movq	$0, 72(%rsp)
	movq	$0, 64(%rsp)
	movl	$-2147483648, 56(%rsp)
	movl	$-2147483648, 48(%rsp)
	movl	$0, 40(%rsp)
	movl	$0, 32(%rsp)
	movl	$13565952, %r9d
	movq	%rcx, %r8
	movq	%rax, %rdx
	movl	$0, %ecx
	movq	__imp_CreateWindowExA(%rip), %rax
	call	*%rax
	movq	%rax, -24(%rbp)
	.loc 1 55 0
	cmpq	$0, -24(%rbp)
	jne	.L5
	.loc 1 56 0
	movl	$0, %eax
	jmp	.L8
.L5:
	.loc 1 58 0
	movl	40(%rbp), %edx
	movq	-24(%rbp), %rax
	movq	%rax, %rcx
	movq	__imp_ShowWindow(%rip), %rax
	call	*%rax
	.loc 1 59 0
	movq	-24(%rbp), %rax
	movq	%rax, %rcx
	movq	__imp_UpdateWindow(%rip), %rax
	call	*%rax
	.loc 1 61 0
	jmp	.L6
.L7:
	.loc 1 63 0
	leaq	-80(%rbp), %rax
	movq	%rax, %rcx
	movq	__imp_TranslateMessage(%rip), %rax
	call	*%rax
	.loc 1 64 0
	leaq	-80(%rbp), %rax
	movq	%rax, %rcx
	movq	__imp_DispatchMessageA(%rip), %rax
	call	*%rax
.L6:
	.loc 1 61 0
	leaq	-80(%rbp), %rax
	movl	$0, %r9d
	movl	$0, %r8d
	movl	$0, %edx
	movq	%rax, %rcx
	movq	__imp_GetMessageA(%rip), %rax
	call	*%rax
	testl	%eax, %eax
	jg	.L7
	.loc 1 66 0
	movq	-64(%rbp), %rax
.L8:
	.loc 1 67 0 discriminator 1
	leave
	.cfi_restore 6
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1949:
	.section .rdata,"dr"
.LC4:
	.ascii "Fenster bewegt\0"
	.text
	.globl	WndProc
	.def	WndProc;	.scl	2;	.type	32;	.endef
WndProc:
.LFB1950:
	.loc 1 70 0
	.cfi_startproc
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register 6
	subq	$32, %rsp
	movq	%rcx, 16(%rbp)
	movl	%edx, 24(%rbp)
	movq	%r8, 32(%rbp)
	movq	%r9, 40(%rbp)
	.loc 1 71 0
	movl	24(%rbp), %eax
	cmpl	$2, %eax
	je	.L11
	cmpl	$3, %eax
	je	.L12
	jmp	.L14
.L11:
	.loc 1 75 0
	movl	$0, %ecx
	movq	__imp_PostQuitMessage(%rip), %rax
	call	*%rax
	.loc 1 76 0
	movl	$0, %eax
	jmp	.L13
.L12:
	.loc 1 80 0
	leaq	.LC4(%rip), %rcx
	call	puts
	.loc 1 81 0
	movl	$0, %eax
	jmp	.L13
.L14:
	.loc 1 84 0
	movq	40(%rbp), %rcx
	movq	32(%rbp), %rdx
	movl	24(%rbp), %eax
	movq	%rcx, %r9
	movq	%rdx, %r8
	movl	%eax, %edx
	movq	16(%rbp), %rcx
	movq	__imp_DefWindowProcA(%rip), %rax
	call	*%rax
.L13:
	.loc 1 85 0
	leave
	.cfi_restore 6
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE1950:
.Letext0:
	.file 2 "c:/mingw12_2/mingw/x86_64-w64-mingw32/include/minwindef.h"
	.file 3 "c:/mingw12_2/mingw/x86_64-w64-mingw32/include/basetsd.h"
	.file 4 "c:/mingw12_2/mingw/x86_64-w64-mingw32/include/winnt.h"
	.file 5 "c:/mingw12_2/mingw/x86_64-w64-mingw32/include/windef.h"
	.file 6 "c:/mingw12_2/mingw/x86_64-w64-mingw32/include/winuser.h"
	.file 7 "c:/mingw12_2/mingw/x86_64-w64-mingw32/include/combaseapi.h"
	.file 8 "c:/mingw12_2/mingw/x86_64-w64-mingw32/include/wtypes.h"
	.file 9 "c:/mingw12_2/mingw/x86_64-w64-mingw32/include/winbase.h"
	.section	.debug_info,"dr"
.Ldebug_info0:
	.long	0x961
	.word	0x4
	.secrel32	.Ldebug_abbrev0
	.byte	0x8
	.uleb128 0x1
	.ascii "GNU C 4.9.2 -mtune=haswell -march=x86-64 -ggdb -fno-asynchronous-unwind-tables\0"
	.byte	0x1
	.ascii "win/win.c\0"
	.ascii "C:\\JavaProjects\\GIT\\Kaputnik120\\C\0"
	.quad	.Ltext0
	.quad	.Letext0-.Ltext0
	.secrel32	.Ldebug_line0
	.uleb128 0x2
	.byte	0x1
	.byte	0x6
	.ascii "char\0"
	.uleb128 0x2
	.byte	0x8
	.byte	0x7
	.ascii "long long unsigned int\0"
	.uleb128 0x2
	.byte	0x8
	.byte	0x5
	.ascii "long long int\0"
	.uleb128 0x2
	.byte	0x2
	.byte	0x7
	.ascii "short unsigned int\0"
	.uleb128 0x2
	.byte	0x4
	.byte	0x5
	.ascii "int\0"
	.uleb128 0x2
	.byte	0x4
	.byte	0x5
	.ascii "long int\0"
	.uleb128 0x2
	.byte	0x4
	.byte	0x7
	.ascii "unsigned int\0"
	.uleb128 0x2
	.byte	0x8
	.byte	0x7
	.ascii "sizetype\0"
	.uleb128 0x2
	.byte	0x4
	.byte	0x7
	.ascii "long unsigned int\0"
	.uleb128 0x2
	.byte	0x1
	.byte	0x8
	.ascii "unsigned char\0"
	.uleb128 0x3
	.ascii "WORD\0"
	.byte	0x2
	.byte	0x7b
	.long	0xcf
	.uleb128 0x3
	.ascii "DWORD\0"
	.byte	0x2
	.byte	0x7c
	.long	0x114
	.uleb128 0x2
	.byte	0x4
	.byte	0x4
	.ascii "float\0"
	.uleb128 0x3
	.ascii "UINT\0"
	.byte	0x2
	.byte	0x8e
	.long	0xf8
	.uleb128 0x2
	.byte	0x1
	.byte	0x6
	.ascii "signed char\0"
	.uleb128 0x2
	.byte	0x2
	.byte	0x5
	.ascii "short int\0"
	.uleb128 0x3
	.ascii "UINT_PTR\0"
	.byte	0x3
	.byte	0x2f
	.long	0xa4
	.uleb128 0x3
	.ascii "LONG_PTR\0"
	.byte	0x3
	.byte	0x30
	.long	0xbe
	.uleb128 0x3
	.ascii "ULONG_PTR\0"
	.byte	0x3
	.byte	0x31
	.long	0xa4
	.uleb128 0x4
	.ascii "CHAR\0"
	.byte	0x4
	.word	0x104
	.long	0x9c
	.uleb128 0x4
	.ascii "LONG\0"
	.byte	0x4
	.word	0x106
	.long	0xec
	.uleb128 0x5
	.byte	0x8
	.long	0x1b5
	.uleb128 0x5
	.byte	0x8
	.long	0x1db
	.uleb128 0x6
	.long	0x1b5
	.uleb128 0x4
	.ascii "LPSTR\0"
	.byte	0x4
	.word	0x137
	.long	0x1cf
	.uleb128 0x4
	.ascii "PSTR\0"
	.byte	0x4
	.word	0x137
	.long	0x1cf
	.uleb128 0x4
	.ascii "LPCSTR\0"
	.byte	0x4
	.word	0x13a
	.long	0x1d5
	.uleb128 0x2
	.byte	0x8
	.byte	0x4
	.ascii "double\0"
	.uleb128 0x2
	.byte	0x10
	.byte	0x4
	.ascii "long double\0"
	.uleb128 0x3
	.ascii "WPARAM\0"
	.byte	0x2
	.byte	0x95
	.long	0x184
	.uleb128 0x3
	.ascii "LPARAM\0"
	.byte	0x2
	.byte	0x96
	.long	0x194
	.uleb128 0x3
	.ascii "LRESULT\0"
	.byte	0x2
	.byte	0x97
	.long	0x194
	.uleb128 0x7
	.ascii "HINSTANCE__\0"
	.byte	0x4
	.byte	0x2
	.byte	0xbf
	.long	0x26f
	.uleb128 0x8
	.secrel32	.LASF0
	.byte	0x2
	.byte	0xbf
	.long	0xe5
	.byte	0
	.byte	0
	.uleb128 0x3
	.ascii "HINSTANCE\0"
	.byte	0x2
	.byte	0xbf
	.long	0x280
	.uleb128 0x5
	.byte	0x8
	.long	0x24e
	.uleb128 0x7
	.ascii "HWND__\0"
	.byte	0x4
	.byte	0x5
	.byte	0x19
	.long	0x2a2
	.uleb128 0x8
	.secrel32	.LASF0
	.byte	0x5
	.byte	0x19
	.long	0xe5
	.byte	0
	.byte	0
	.uleb128 0x3
	.ascii "HWND\0"
	.byte	0x5
	.byte	0x19
	.long	0x2ae
	.uleb128 0x5
	.byte	0x8
	.long	0x286
	.uleb128 0x7
	.ascii "HBRUSH__\0"
	.byte	0x4
	.byte	0x5
	.byte	0x2c
	.long	0x2d2
	.uleb128 0x8
	.secrel32	.LASF0
	.byte	0x5
	.byte	0x2c
	.long	0xe5
	.byte	0
	.byte	0
	.uleb128 0x3
	.ascii "HBRUSH\0"
	.byte	0x5
	.byte	0x2c
	.long	0x2e0
	.uleb128 0x5
	.byte	0x8
	.long	0x2b4
	.uleb128 0x7
	.ascii "HICON__\0"
	.byte	0x4
	.byte	0x5
	.byte	0x33
	.long	0x303
	.uleb128 0x8
	.secrel32	.LASF0
	.byte	0x5
	.byte	0x33
	.long	0xe5
	.byte	0
	.byte	0
	.uleb128 0x3
	.ascii "HICON\0"
	.byte	0x5
	.byte	0x33
	.long	0x310
	.uleb128 0x5
	.byte	0x8
	.long	0x2e6
	.uleb128 0x3
	.ascii "HCURSOR\0"
	.byte	0x5
	.byte	0x3a
	.long	0x303
	.uleb128 0x7
	.ascii "tagPOINT\0"
	.byte	0x8
	.byte	0x5
	.byte	0x59
	.long	0x34b
	.uleb128 0x9
	.ascii "x\0"
	.byte	0x5
	.byte	0x5a
	.long	0x1c2
	.byte	0
	.uleb128 0x9
	.ascii "y\0"
	.byte	0x5
	.byte	0x5b
	.long	0x1c2
	.byte	0x4
	.byte	0
	.uleb128 0x3
	.ascii "POINT\0"
	.byte	0x5
	.byte	0x5c
	.long	0x325
	.uleb128 0x3
	.ascii "WNDPROC\0"
	.byte	0x6
	.byte	0x22
	.long	0x367
	.uleb128 0x5
	.byte	0x8
	.long	0x36d
	.uleb128 0xa
	.long	0x23f
	.long	0x38b
	.uleb128 0xb
	.long	0x2a2
	.uleb128 0xb
	.long	0x15c
	.uleb128 0xb
	.long	0x223
	.uleb128 0xb
	.long	0x231
	.byte	0
	.uleb128 0xc
	.ascii "tagWNDCLASSEXA\0"
	.byte	0x50
	.byte	0x6
	.word	0x2ef
	.long	0x482
	.uleb128 0xd
	.ascii "cbSize\0"
	.byte	0x6
	.word	0x2f0
	.long	0x15c
	.byte	0
	.uleb128 0xd
	.ascii "style\0"
	.byte	0x6
	.word	0x2f1
	.long	0x15c
	.byte	0x4
	.uleb128 0xd
	.ascii "lpfnWndProc\0"
	.byte	0x6
	.word	0x2f2
	.long	0x358
	.byte	0x8
	.uleb128 0xd
	.ascii "cbClsExtra\0"
	.byte	0x6
	.word	0x2f3
	.long	0xe5
	.byte	0x10
	.uleb128 0xd
	.ascii "cbWndExtra\0"
	.byte	0x6
	.word	0x2f4
	.long	0xe5
	.byte	0x14
	.uleb128 0xe
	.secrel32	.LASF1
	.byte	0x6
	.word	0x2f5
	.long	0x26f
	.byte	0x18
	.uleb128 0xd
	.ascii "hIcon\0"
	.byte	0x6
	.word	0x2f6
	.long	0x303
	.byte	0x20
	.uleb128 0xd
	.ascii "hCursor\0"
	.byte	0x6
	.word	0x2f7
	.long	0x316
	.byte	0x28
	.uleb128 0xd
	.ascii "hbrBackground\0"
	.byte	0x6
	.word	0x2f8
	.long	0x2d2
	.byte	0x30
	.uleb128 0xd
	.ascii "lpszMenuName\0"
	.byte	0x6
	.word	0x2f9
	.long	0x1fb
	.byte	0x38
	.uleb128 0xd
	.ascii "lpszClassName\0"
	.byte	0x6
	.word	0x2fa
	.long	0x1fb
	.byte	0x40
	.uleb128 0xd
	.ascii "hIconSm\0"
	.byte	0x6
	.word	0x2fb
	.long	0x303
	.byte	0x48
	.byte	0
	.uleb128 0x4
	.ascii "WNDCLASSEXA\0"
	.byte	0x6
	.word	0x2fc
	.long	0x38b
	.uleb128 0x4
	.ascii "WNDCLASSEX\0"
	.byte	0x6
	.word	0x30e
	.long	0x482
	.uleb128 0xc
	.ascii "tagMSG\0"
	.byte	0x30
	.byte	0x6
	.word	0x336
	.long	0x513
	.uleb128 0xd
	.ascii "hwnd\0"
	.byte	0x6
	.word	0x337
	.long	0x2a2
	.byte	0
	.uleb128 0xd
	.ascii "message\0"
	.byte	0x6
	.word	0x338
	.long	0x15c
	.byte	0x8
	.uleb128 0xd
	.ascii "wParam\0"
	.byte	0x6
	.word	0x339
	.long	0x223
	.byte	0x10
	.uleb128 0xd
	.ascii "lParam\0"
	.byte	0x6
	.word	0x33a
	.long	0x231
	.byte	0x18
	.uleb128 0xd
	.ascii "time\0"
	.byte	0x6
	.word	0x33b
	.long	0x146
	.byte	0x20
	.uleb128 0xd
	.ascii "pt\0"
	.byte	0x6
	.word	0x33c
	.long	0x34b
	.byte	0x24
	.byte	0
	.uleb128 0x4
	.ascii "MSG\0"
	.byte	0x6
	.word	0x33d
	.long	0x4a9
	.uleb128 0xf
	.ascii "tagCOINITBASE\0"
	.byte	0x4
	.byte	0x7
	.byte	0x95
	.long	0x551
	.uleb128 0x10
	.ascii "COINITBASE_MULTITHREADED\0"
	.sleb128 0
	.byte	0
	.uleb128 0x11
	.ascii "VARENUM\0"
	.byte	0x4
	.byte	0x8
	.word	0x200
	.long	0x7e5
	.uleb128 0x10
	.ascii "VT_EMPTY\0"
	.sleb128 0
	.uleb128 0x10
	.ascii "VT_NULL\0"
	.sleb128 1
	.uleb128 0x10
	.ascii "VT_I2\0"
	.sleb128 2
	.uleb128 0x10
	.ascii "VT_I4\0"
	.sleb128 3
	.uleb128 0x10
	.ascii "VT_R4\0"
	.sleb128 4
	.uleb128 0x10
	.ascii "VT_R8\0"
	.sleb128 5
	.uleb128 0x10
	.ascii "VT_CY\0"
	.sleb128 6
	.uleb128 0x10
	.ascii "VT_DATE\0"
	.sleb128 7
	.uleb128 0x10
	.ascii "VT_BSTR\0"
	.sleb128 8
	.uleb128 0x10
	.ascii "VT_DISPATCH\0"
	.sleb128 9
	.uleb128 0x10
	.ascii "VT_ERROR\0"
	.sleb128 10
	.uleb128 0x10
	.ascii "VT_BOOL\0"
	.sleb128 11
	.uleb128 0x10
	.ascii "VT_VARIANT\0"
	.sleb128 12
	.uleb128 0x10
	.ascii "VT_UNKNOWN\0"
	.sleb128 13
	.uleb128 0x10
	.ascii "VT_DECIMAL\0"
	.sleb128 14
	.uleb128 0x10
	.ascii "VT_I1\0"
	.sleb128 16
	.uleb128 0x10
	.ascii "VT_UI1\0"
	.sleb128 17
	.uleb128 0x10
	.ascii "VT_UI2\0"
	.sleb128 18
	.uleb128 0x10
	.ascii "VT_UI4\0"
	.sleb128 19
	.uleb128 0x10
	.ascii "VT_I8\0"
	.sleb128 20
	.uleb128 0x10
	.ascii "VT_UI8\0"
	.sleb128 21
	.uleb128 0x10
	.ascii "VT_INT\0"
	.sleb128 22
	.uleb128 0x10
	.ascii "VT_UINT\0"
	.sleb128 23
	.uleb128 0x10
	.ascii "VT_VOID\0"
	.sleb128 24
	.uleb128 0x10
	.ascii "VT_HRESULT\0"
	.sleb128 25
	.uleb128 0x10
	.ascii "VT_PTR\0"
	.sleb128 26
	.uleb128 0x10
	.ascii "VT_SAFEARRAY\0"
	.sleb128 27
	.uleb128 0x10
	.ascii "VT_CARRAY\0"
	.sleb128 28
	.uleb128 0x10
	.ascii "VT_USERDEFINED\0"
	.sleb128 29
	.uleb128 0x10
	.ascii "VT_LPSTR\0"
	.sleb128 30
	.uleb128 0x10
	.ascii "VT_LPWSTR\0"
	.sleb128 31
	.uleb128 0x10
	.ascii "VT_RECORD\0"
	.sleb128 36
	.uleb128 0x10
	.ascii "VT_INT_PTR\0"
	.sleb128 37
	.uleb128 0x10
	.ascii "VT_UINT_PTR\0"
	.sleb128 38
	.uleb128 0x10
	.ascii "VT_FILETIME\0"
	.sleb128 64
	.uleb128 0x10
	.ascii "VT_BLOB\0"
	.sleb128 65
	.uleb128 0x10
	.ascii "VT_STREAM\0"
	.sleb128 66
	.uleb128 0x10
	.ascii "VT_STORAGE\0"
	.sleb128 67
	.uleb128 0x10
	.ascii "VT_STREAMED_OBJECT\0"
	.sleb128 68
	.uleb128 0x10
	.ascii "VT_STORED_OBJECT\0"
	.sleb128 69
	.uleb128 0x10
	.ascii "VT_BLOB_OBJECT\0"
	.sleb128 70
	.uleb128 0x10
	.ascii "VT_CF\0"
	.sleb128 71
	.uleb128 0x10
	.ascii "VT_CLSID\0"
	.sleb128 72
	.uleb128 0x10
	.ascii "VT_VERSIONED_STREAM\0"
	.sleb128 73
	.uleb128 0x10
	.ascii "VT_BSTR_BLOB\0"
	.sleb128 4095
	.uleb128 0x10
	.ascii "VT_VECTOR\0"
	.sleb128 4096
	.uleb128 0x10
	.ascii "VT_ARRAY\0"
	.sleb128 8192
	.uleb128 0x10
	.ascii "VT_BYREF\0"
	.sleb128 16384
	.uleb128 0x10
	.ascii "VT_RESERVED\0"
	.sleb128 32768
	.uleb128 0x10
	.ascii "VT_ILLEGAL\0"
	.sleb128 65535
	.uleb128 0x10
	.ascii "VT_ILLEGALMASKED\0"
	.sleb128 4095
	.uleb128 0x10
	.ascii "VT_TYPEMASK\0"
	.sleb128 4095
	.byte	0
	.uleb128 0x12
	.ascii "os\0"
	.byte	0x1
	.byte	0x4
	.quad	.LFB1948
	.quad	.LFE1948-.LFB1948
	.uleb128 0x1
	.byte	0x9c
	.uleb128 0x13
	.ascii "WinMain\0"
	.byte	0x9
	.word	0x429
	.long	0xe5
	.quad	.LFB1949
	.quad	.LFE1949-.LFB1949
	.uleb128 0x1
	.byte	0x9c
	.long	0x8c6
	.uleb128 0x14
	.secrel32	.LASF1
	.byte	0x1
	.byte	0xd
	.long	0x26f
	.uleb128 0x2
	.byte	0x91
	.sleb128 0
	.uleb128 0x15
	.ascii "hPrevInstance\0"
	.byte	0x1
	.byte	0xe
	.long	0x26f
	.uleb128 0x2
	.byte	0x91
	.sleb128 8
	.uleb128 0x15
	.ascii "szCmdLine\0"
	.byte	0x1
	.byte	0xe
	.long	0x1ee
	.uleb128 0x2
	.byte	0x91
	.sleb128 16
	.uleb128 0x15
	.ascii "iCmdShow\0"
	.byte	0x1
	.byte	0xe
	.long	0xe5
	.uleb128 0x2
	.byte	0x91
	.sleb128 24
	.uleb128 0x16
	.ascii "i\0"
	.byte	0x1
	.byte	0x11
	.long	0xe5
	.uleb128 0x2
	.byte	0x91
	.sleb128 -20
	.uleb128 0x16
	.ascii "j\0"
	.byte	0x1
	.byte	0x12
	.long	0xe5
	.uleb128 0x2
	.byte	0x91
	.sleb128 -24
	.uleb128 0x16
	.ascii "result\0"
	.byte	0x1
	.byte	0x13
	.long	0xe5
	.uleb128 0x2
	.byte	0x91
	.sleb128 -28
	.uleb128 0x16
	.ascii "hWnd\0"
	.byte	0x1
	.byte	0x16
	.long	0x2a2
	.uleb128 0x2
	.byte	0x91
	.sleb128 -40
	.uleb128 0x16
	.ascii "msg\0"
	.byte	0x1
	.byte	0x17
	.long	0x513
	.uleb128 0x3
	.byte	0x91
	.sleb128 -96
	.uleb128 0x16
	.ascii "wc\0"
	.byte	0x1
	.byte	0x18
	.long	0x496
	.uleb128 0x3
	.byte	0x91
	.sleb128 -176
	.byte	0
	.uleb128 0x17
	.ascii "WndProc\0"
	.byte	0x1
	.byte	0x45
	.long	0x23f
	.quad	.LFB1950
	.quad	.LFE1950-.LFB1950
	.uleb128 0x1
	.byte	0x9c
	.long	0x92c
	.uleb128 0x15
	.ascii "hWnd\0"
	.byte	0x1
	.byte	0x45
	.long	0x2a2
	.uleb128 0x2
	.byte	0x91
	.sleb128 0
	.uleb128 0x15
	.ascii "umsg\0"
	.byte	0x1
	.byte	0x45
	.long	0x15c
	.uleb128 0x2
	.byte	0x91
	.sleb128 8
	.uleb128 0x15
	.ascii "wParam\0"
	.byte	0x1
	.byte	0x45
	.long	0x223
	.uleb128 0x2
	.byte	0x91
	.sleb128 16
	.uleb128 0x15
	.ascii "lParam\0"
	.byte	0x1
	.byte	0x45
	.long	0x231
	.uleb128 0x2
	.byte	0x91
	.sleb128 24
	.byte	0
	.uleb128 0x18
	.ascii "lpszAppName\0"
	.byte	0x1
	.byte	0xa
	.long	0x1fb
	.uleb128 0x9
	.byte	0x3
	.quad	lpszAppName
	.uleb128 0x18
	.ascii "lpszTitle\0"
	.byte	0x1
	.byte	0xb
	.long	0x1fb
	.uleb128 0x9
	.byte	0x3
	.quad	lpszTitle
	.byte	0
	.section	.debug_abbrev,"dr"
.Ldebug_abbrev0:
	.uleb128 0x1
	.uleb128 0x11
	.byte	0x1
	.uleb128 0x25
	.uleb128 0x8
	.uleb128 0x13
	.uleb128 0xb
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x1b
	.uleb128 0x8
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x12
	.uleb128 0x7
	.uleb128 0x10
	.uleb128 0x17
	.byte	0
	.byte	0
	.uleb128 0x2
	.uleb128 0x24
	.byte	0
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3e
	.uleb128 0xb
	.uleb128 0x3
	.uleb128 0x8
	.byte	0
	.byte	0
	.uleb128 0x3
	.uleb128 0x16
	.byte	0
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x4
	.uleb128 0x16
	.byte	0
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x5
	.uleb128 0xf
	.byte	0
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x6
	.uleb128 0x26
	.byte	0
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x7
	.uleb128 0x13
	.byte	0x1
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x8
	.uleb128 0xd
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x38
	.uleb128 0xb
	.byte	0
	.byte	0
	.uleb128 0x9
	.uleb128 0xd
	.byte	0
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x38
	.uleb128 0xb
	.byte	0
	.byte	0
	.uleb128 0xa
	.uleb128 0x15
	.byte	0x1
	.uleb128 0x27
	.uleb128 0x19
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0xb
	.uleb128 0x5
	.byte	0
	.uleb128 0x49
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0xc
	.uleb128 0x13
	.byte	0x1
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0xd
	.uleb128 0xd
	.byte	0
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x38
	.uleb128 0xb
	.byte	0
	.byte	0
	.uleb128 0xe
	.uleb128 0xd
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x38
	.uleb128 0xb
	.byte	0
	.byte	0
	.uleb128 0xf
	.uleb128 0x4
	.byte	0x1
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x10
	.uleb128 0x28
	.byte	0
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x1c
	.uleb128 0xd
	.byte	0
	.byte	0
	.uleb128 0x11
	.uleb128 0x4
	.byte	0x1
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0xb
	.uleb128 0xb
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x12
	.uleb128 0x2e
	.byte	0
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x12
	.uleb128 0x7
	.uleb128 0x40
	.uleb128 0x18
	.uleb128 0x2116
	.uleb128 0x19
	.byte	0
	.byte	0
	.uleb128 0x13
	.uleb128 0x2e
	.byte	0x1
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0x5
	.uleb128 0x27
	.uleb128 0x19
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x12
	.uleb128 0x7
	.uleb128 0x40
	.uleb128 0x18
	.uleb128 0x2116
	.uleb128 0x19
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x14
	.uleb128 0x5
	.byte	0
	.uleb128 0x3
	.uleb128 0xe
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x2
	.uleb128 0x18
	.byte	0
	.byte	0
	.uleb128 0x15
	.uleb128 0x5
	.byte	0
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x2
	.uleb128 0x18
	.byte	0
	.byte	0
	.uleb128 0x16
	.uleb128 0x34
	.byte	0
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x2
	.uleb128 0x18
	.byte	0
	.byte	0
	.uleb128 0x17
	.uleb128 0x2e
	.byte	0x1
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x27
	.uleb128 0x19
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x11
	.uleb128 0x1
	.uleb128 0x12
	.uleb128 0x7
	.uleb128 0x40
	.uleb128 0x18
	.uleb128 0x2116
	.uleb128 0x19
	.uleb128 0x1
	.uleb128 0x13
	.byte	0
	.byte	0
	.uleb128 0x18
	.uleb128 0x34
	.byte	0
	.uleb128 0x3
	.uleb128 0x8
	.uleb128 0x3a
	.uleb128 0xb
	.uleb128 0x3b
	.uleb128 0xb
	.uleb128 0x49
	.uleb128 0x13
	.uleb128 0x3f
	.uleb128 0x19
	.uleb128 0x2
	.uleb128 0x18
	.byte	0
	.byte	0
	.byte	0
	.section	.debug_aranges,"dr"
	.long	0x2c
	.word	0x2
	.secrel32	.Ldebug_info0
	.byte	0x8
	.byte	0
	.word	0
	.word	0
	.quad	.Ltext0
	.quad	.Letext0-.Ltext0
	.quad	0
	.quad	0
	.section	.debug_line,"dr"
.Ldebug_line0:
	.section	.debug_str,"dr"
.LASF0:
	.ascii "unused\0"
.LASF1:
	.ascii "hInstance\0"
	.ident	"GCC: (GNU) 4.9.2"
	.def	puts;	.scl	2;	.type	32;	.endef
	.def	printf;	.scl	2;	.type	32;	.endef
