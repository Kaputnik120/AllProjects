   1              		.file	"main.c"
   2              		.text
   3              	.Ltext0:
   4              		.cfi_sections	.debug_frame
   5              		.def	__main;	.scl	2;	.type	32;	.endef
   6              		.globl	main
   7              		.def	main;	.scl	2;	.type	32;	.endef
   8              		.seh_proc	main
   9              	main:
  10              	.LFB16:
  11              		.file 1 "main.c"
  12              		.loc 1 15 0
  13              		.cfi_startproc
  14 0000 55       		pushq	%rbp
  15              		.seh_pushreg	%rbp
  16              		.cfi_def_cfa_offset 16
  17              		.cfi_offset 6, -16
  18 0001 4889E5   		movq	%rsp, %rbp
  19              		.seh_setframe	%rbp, 0
  20              		.cfi_def_cfa_register 6
  21 0004 4883EC20 		subq	$32, %rsp
  22              		.seh_stackalloc	32
  23              		.seh_endprologue
  24 0008 894D10   		movl	%ecx, 16(%rbp)
  25 000b 48895518 		movq	%rdx, 24(%rbp)
  26              		.loc 1 15 0
  27 000f E8000000 		call	__main
  27      00
  28              		.loc 1 17 0
  29 0014 B8000000 		movl	$0, %eax
  29      00
  30              		.loc 1 18 0
  31 0019 4883C420 		addq	$32, %rsp
  32 001d 5D       		popq	%rbp
  33              		.cfi_restore 6
  34              		.cfi_def_cfa 7, 8
  35 001e C3       		ret
  36              		.cfi_endproc
  37              	.LFE16:
  38              		.seh_endproc
  39              	.Letext0:
  40 001f 90       		.section	.debug_info,"dr"
  41              	.Ldebug_info0:
  42 0000 93010000 		.long	0x193
  43 0004 0400     		.word	0x4
  44 0006 00000000 		.secrel32	.Ldebug_abbrev0
  45 000a 08       		.byte	0x8
  46 000b 01       		.uleb128 0x1
  47 000c 474E5520 		.ascii "GNU C 4.9.2 -mtune=haswell -march=x86-64 -g\0"
  47      4320342E 
  47      392E3220 
  47      2D6D7475 
  47      6E653D68 
  48 0038 01       		.byte	0x1
  49 0039 6D61696E 		.ascii "main.c\0"
  49      2E6300
  50 0040 433A5C4A 		.ascii "C:\\JavaProjects\\GIT\\Kaputnik120\\C-Standard\\CStandard\0"
  50      61766150 
  50      726F6A65 
  50      6374735C 
  50      4749545C 
  51 0075 00000000 		.quad	.Ltext0
  51      00000000 
  52 007d 1F000000 		.quad	.Letext0-.Ltext0
  52      00000000 
  53 0085 00000000 		.secrel32	.Ldebug_line0
  54 0089 02       		.uleb128 0x2
  55 008a 01       		.byte	0x1
  56 008b 06       		.byte	0x6
  57 008c 63686172 		.ascii "char\0"
  57      00
  58 0091 02       		.uleb128 0x2
  59 0092 08       		.byte	0x8
  60 0093 07       		.byte	0x7
  61 0094 6C6F6E67 		.ascii "long long unsigned int\0"
  61      206C6F6E 
  61      6720756E 
  61      7369676E 
  61      65642069 
  62 00ab 02       		.uleb128 0x2
  63 00ac 08       		.byte	0x8
  64 00ad 05       		.byte	0x5
  65 00ae 6C6F6E67 		.ascii "long long int\0"
  65      206C6F6E 
  65      6720696E 
  65      7400
  66 00bc 02       		.uleb128 0x2
  67 00bd 02       		.byte	0x2
  68 00be 07       		.byte	0x7
  69 00bf 73686F72 		.ascii "short unsigned int\0"
  69      7420756E 
  69      7369676E 
  69      65642069 
  69      6E7400
  70 00d2 02       		.uleb128 0x2
  71 00d3 04       		.byte	0x4
  72 00d4 05       		.byte	0x5
  73 00d5 696E7400 		.ascii "int\0"
  74 00d9 02       		.uleb128 0x2
  75 00da 04       		.byte	0x4
  76 00db 05       		.byte	0x5
  77 00dc 6C6F6E67 		.ascii "long int\0"
  77      20696E74 
  77      00
  78 00e5 03       		.uleb128 0x3
  79 00e6 08       		.byte	0x8
  80 00e7 89000000 		.long	0x89
  81 00eb 02       		.uleb128 0x2
  82 00ec 04       		.byte	0x4
  83 00ed 07       		.byte	0x7
  84 00ee 756E7369 		.ascii "unsigned int\0"
  84      676E6564 
  84      20696E74 
  84      00
  85 00fb 02       		.uleb128 0x2
  86 00fc 08       		.byte	0x8
  87 00fd 07       		.byte	0x7
  88 00fe 73697A65 		.ascii "sizetype\0"
  88      74797065 
  88      00
  89 0107 02       		.uleb128 0x2
  90 0108 04       		.byte	0x4
  91 0109 07       		.byte	0x7
  92 010a 6C6F6E67 		.ascii "long unsigned int\0"
  92      20756E73 
  92      69676E65 
  92      6420696E 
  92      7400
  93 011c 02       		.uleb128 0x2
  94 011d 01       		.byte	0x1
  95 011e 08       		.byte	0x8
  96 011f 756E7369 		.ascii "unsigned char\0"
  96      676E6564 
  96      20636861 
  96      7200
  97 012d 02       		.uleb128 0x2
  98 012e 08       		.byte	0x8
  99 012f 04       		.byte	0x4
 100 0130 646F7562 		.ascii "double\0"
 100      6C6500
 101 0137 02       		.uleb128 0x2
 102 0138 04       		.byte	0x4
 103 0139 04       		.byte	0x4
 104 013a 666C6F61 		.ascii "float\0"
 104      7400
 105 0140 02       		.uleb128 0x2
 106 0141 10       		.byte	0x10
 107 0142 04       		.byte	0x4
 108 0143 6C6F6E67 		.ascii "long double\0"
 108      20646F75 
 108      626C6500 
 109 014f 04       		.uleb128 0x4
 110 0150 6D61696E 		.ascii "main\0"
 110      00
 111 0155 01       		.byte	0x1
 112 0156 0F       		.byte	0xf
 113 0157 D2000000 		.long	0xd2
 114 015b 00000000 		.quad	.LFB16
 114      00000000 
 115 0163 1F000000 		.quad	.LFE16-.LFB16
 115      00000000 
 116 016b 01       		.uleb128 0x1
 117 016c 9C       		.byte	0x9c
 118 016d 90010000 		.long	0x190
 119 0171 05       		.uleb128 0x5
 120 0172 61726763 		.ascii "argc\0"
 120      00
 121 0177 01       		.byte	0x1
 122 0178 0F       		.byte	0xf
 123 0179 D2000000 		.long	0xd2
 124 017d 02       		.uleb128 0x2
 125 017e 91       		.byte	0x91
 126 017f 00       		.sleb128 0
 127 0180 05       		.uleb128 0x5
 128 0181 61726776 		.ascii "argv\0"
 128      00
 129 0186 01       		.byte	0x1
 130 0187 0F       		.byte	0xf
 131 0188 90010000 		.long	0x190
 132 018c 02       		.uleb128 0x2
 133 018d 91       		.byte	0x91
 134 018e 08       		.sleb128 8
 135 018f 00       		.byte	0
 136 0190 03       		.uleb128 0x3
 137 0191 08       		.byte	0x8
 138 0192 E5000000 		.long	0xe5
 139 0196 00       		.byte	0
 140              		.section	.debug_abbrev,"dr"
 141              	.Ldebug_abbrev0:
 142 0000 01       		.uleb128 0x1
 143 0001 11       		.uleb128 0x11
 144 0002 01       		.byte	0x1
 145 0003 25       		.uleb128 0x25
 146 0004 08       		.uleb128 0x8
 147 0005 13       		.uleb128 0x13
 148 0006 0B       		.uleb128 0xb
 149 0007 03       		.uleb128 0x3
 150 0008 08       		.uleb128 0x8
 151 0009 1B       		.uleb128 0x1b
 152 000a 08       		.uleb128 0x8
 153 000b 11       		.uleb128 0x11
 154 000c 01       		.uleb128 0x1
 155 000d 12       		.uleb128 0x12
 156 000e 07       		.uleb128 0x7
 157 000f 10       		.uleb128 0x10
 158 0010 17       		.uleb128 0x17
 159 0011 00       		.byte	0
 160 0012 00       		.byte	0
 161 0013 02       		.uleb128 0x2
 162 0014 24       		.uleb128 0x24
 163 0015 00       		.byte	0
 164 0016 0B       		.uleb128 0xb
 165 0017 0B       		.uleb128 0xb
 166 0018 3E       		.uleb128 0x3e
 167 0019 0B       		.uleb128 0xb
 168 001a 03       		.uleb128 0x3
 169 001b 08       		.uleb128 0x8
 170 001c 00       		.byte	0
 171 001d 00       		.byte	0
 172 001e 03       		.uleb128 0x3
 173 001f 0F       		.uleb128 0xf
 174 0020 00       		.byte	0
 175 0021 0B       		.uleb128 0xb
 176 0022 0B       		.uleb128 0xb
 177 0023 49       		.uleb128 0x49
 178 0024 13       		.uleb128 0x13
 179 0025 00       		.byte	0
 180 0026 00       		.byte	0
 181 0027 04       		.uleb128 0x4
 182 0028 2E       		.uleb128 0x2e
 183 0029 01       		.byte	0x1
 184 002a 3F       		.uleb128 0x3f
 185 002b 19       		.uleb128 0x19
 186 002c 03       		.uleb128 0x3
 187 002d 08       		.uleb128 0x8
 188 002e 3A       		.uleb128 0x3a
 189 002f 0B       		.uleb128 0xb
 190 0030 3B       		.uleb128 0x3b
 191 0031 0B       		.uleb128 0xb
 192 0032 27       		.uleb128 0x27
 193 0033 19       		.uleb128 0x19
 194 0034 49       		.uleb128 0x49
 195 0035 13       		.uleb128 0x13
 196 0036 11       		.uleb128 0x11
 197 0037 01       		.uleb128 0x1
 198 0038 12       		.uleb128 0x12
 199 0039 07       		.uleb128 0x7
 200 003a 40       		.uleb128 0x40
 201 003b 18       		.uleb128 0x18
 202 003c 9642     		.uleb128 0x2116
 203 003e 19       		.uleb128 0x19
 204 003f 01       		.uleb128 0x1
 205 0040 13       		.uleb128 0x13
 206 0041 00       		.byte	0
 207 0042 00       		.byte	0
 208 0043 05       		.uleb128 0x5
 209 0044 05       		.uleb128 0x5
 210 0045 00       		.byte	0
 211 0046 03       		.uleb128 0x3
 212 0047 08       		.uleb128 0x8
 213 0048 3A       		.uleb128 0x3a
 214 0049 0B       		.uleb128 0xb
 215 004a 3B       		.uleb128 0x3b
 216 004b 0B       		.uleb128 0xb
 217 004c 49       		.uleb128 0x49
 218 004d 13       		.uleb128 0x13
 219 004e 02       		.uleb128 0x2
 220 004f 18       		.uleb128 0x18
 221 0050 00       		.byte	0
 222 0051 00       		.byte	0
 223 0052 00       		.byte	0
 224              		.section	.debug_aranges,"dr"
 225 0000 2C000000 		.long	0x2c
 226 0004 0200     		.word	0x2
 227 0006 00000000 		.secrel32	.Ldebug_info0
 228 000a 08       		.byte	0x8
 229 000b 00       		.byte	0
 230 000c 0000     		.word	0
 231 000e 0000     		.word	0
 232 0010 00000000 		.quad	.Ltext0
 232      00000000 
 233 0018 1F000000 		.quad	.Letext0-.Ltext0
 233      00000000 
 234 0020 00000000 		.quad	0
 234      00000000 
 235 0028 00000000 		.quad	0
 235      00000000 
 236              		.section	.debug_line,"dr"
 237              	.Ldebug_line0:
 238 0000 39000000 		.section	.debug_str,"dr"
 238      02001D00 
 238      00000101 
 238      FB0E0D00 
 238      01010101 
 239              		.ident	"GCC: (GNU) 4.9.2"
