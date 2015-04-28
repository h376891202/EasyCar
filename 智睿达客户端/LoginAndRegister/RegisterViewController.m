//
//  RegisterViewController.m
//  智睿达客户端
//
//  Created by tony1220 on 15/4/27.
//  Copyright (c) 2015年 tony1220. All rights reserved.
//

#import "RegisterViewController.h"
#import "RegisterView.h"
@interface RegisterViewController ()
{
    RegisterView *_registerView;
}

@end

@implementation RegisterViewController

- (void)dealloc
{
    [_registerView removeFromSuperview];
    _registerView = nil;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    [self initializeAppearance];
    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (void)initializeAppearance
{
    _registerView = [[[NSBundle mainBundle]loadNibNamed:@"Register" owner:nil options:nil]lastObject];
    _registerView.frame = CGRectMake(0, 0, SCREEN_Width, SCREEN_Height);
    [_registerView.backButton addTarget:self action:@selector(backLastViewcontroller) forControlEvents:UIControlEventTouchUpInside];
    [self.view addSubview:_registerView];
}


//返回上一级菜单
- (void)backLastViewcontroller
{
    [self.navigationController popViewControllerAnimated:YES];
}

@end
